import sys

K, N = map(int, sys.stdin.readline().split())
lines = [int(sys.stdin.readline()) for _ in range(K)]

left = 1
right = max(lines)
result = 0

while left <= right:
    mid = (left + right) // 2
    cnt = sum(line // mid for line in lines)

    if cnt >= N:
        result = mid  # 가능한 길이 저장
        left = mid + 1  # 더 긴 길이로 도전
    else:
        right = mid - 1  # 너무 많이 잘림 → 길이 줄이기

print(result)