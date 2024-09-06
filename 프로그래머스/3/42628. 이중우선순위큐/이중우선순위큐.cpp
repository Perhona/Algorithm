#include <string>
#include <vector>
#include <queue>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> operations) {
    priority_queue<int> maxHeap; // 최대 힙
    priority_queue<int, vector<int>, greater<int>> minHeap; // 최소 힙
    unordered_map<int, int> countMap; // 삽입된 숫자의 개수를 관리할 맵
    int size = 0; // 유효한 원소의 개수

    for (const string& operation : operations) {
        char op = operation[0]; // 명령어 'I' 또는 'D'
        int num = stoi(operation.substr(2)); // 숫자 부분

        if (op == 'I') {
            // 숫자 삽입
            maxHeap.push(num);
            minHeap.push(num);
            countMap[num]++;
            size++;
        } else if (size > 0) {
            if (num == 1) {
                // 최댓값 삭제
                while (!maxHeap.empty() && countMap[maxHeap.top()] == 0) {
                    maxHeap.pop(); // 이미 사용된 최댓값 제거
                }
                if (!maxHeap.empty()) {
                    int maxVal = maxHeap.top();
                    maxHeap.pop();
                    countMap[maxVal]--;
                    size--;
                }
            } else if (num == -1) {
                // 최솟값 삭제
                while (!minHeap.empty() && countMap[minHeap.top()] == 0) {
                    minHeap.pop(); // 이미 사용된 최솟값 제거
                }
                if (!minHeap.empty()) {
                    int minVal = minHeap.top();
                    minHeap.pop();
                    countMap[minVal]--;
                    size--;
                }
            }
        }
    }

    // 유효한 최댓값과 최솟값을 찾기 위해 다시 정리
    while (!maxHeap.empty() && countMap[maxHeap.top()] == 0) {
        maxHeap.pop();
    }
    while (!minHeap.empty() && countMap[minHeap.top()] == 0) {
        minHeap.pop();
    }

    if (size == 0) {
        return {0, 0}; // 큐가 비어 있는 경우
    } else {
        return {maxHeap.top(), minHeap.top()}; // 최댓값과 최솟값 반환
    }
}
