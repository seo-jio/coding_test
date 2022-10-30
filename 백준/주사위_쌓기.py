import sys

n = int(sys.stdin.readline())
dices = [
    list(map(int, sys.stdin.readline().split()))
    for _ in range(n)
]


for i in range(1, 7):
    start = i
    for j in range(n):
