import sys

T = int(sys.stdin.readline())

for i in range(T):
    input = sys.stdin.readline().split()
    n = int(input[0])
    s = input[1]
    for char in s:
        print(char*n, end="")
    print()