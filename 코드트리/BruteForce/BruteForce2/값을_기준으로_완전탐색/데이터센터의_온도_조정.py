import sys

n, c, g, h = map(int, input().split())
tps = [
    tuple(map(int, input().split()))
    for _ in range(n)
]
max_work = -sys.maxsize

for i in range(0, 1000):
    work = 0
    for tp in tps:
        low = tp[0]
        high = tp[1]
        if i < low:
            work += c
        elif low <= i <= high:
            work += g
        else:
            work += h
    max_work = max(max_work, work)
print(max_work)