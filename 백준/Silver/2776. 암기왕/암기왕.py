import sys

T = int(sys.stdin.readline())

for case in range(T):
    M = sys.stdin.readline()
    note1 = set(map(int, sys.stdin.readline().split()))

    N = sys.stdin.readline()
    for note2 in map(int, sys.stdin.readline().split()):
        print(1 if note2 in note1 else 0)
