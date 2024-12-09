import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자: 1~5
        // 2번 수포자: 2 + 1 3 4 5
        // 3번 수포자: 3*2 1 2 4 5 ...
        int[] mathPoorA = new int[] {1,2,3,4,5};
        int[] mathPoorB = new int[] {2,1,2,3,2,4,2,5};
        int[] mathPoorC = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[4];
        for (int i=0;i<answers.length;i++) {
            int answer = answers[i];
            if (answer == mathPoorA[i % mathPoorA.length]) count[1]++;
            if (answer == mathPoorB[i % mathPoorB.length]) count[2]++;
            if (answer == mathPoorC[i % mathPoorC.length]) count[3]++;
        }
        int maxNum = Arrays.stream(count).max().getAsInt();
        List<Integer> answerList = new ArrayList<>();
        for (int i=1;i<count.length;i++) {
            if (count[i] == maxNum) {
                answerList.add(i);
            }
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}