import sys
N = int(sys.stdin.readline())
numbers = sys.stdin.readline().strip()

print(sum(map(int, numbers)))