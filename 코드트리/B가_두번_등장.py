import sys

n, k = map(int, input().split())
arr = [0] * n

count = 1
for i in range(n-1, -1, -1):
    for j in range(i-1, -1, -1):
        if count == k:
            print(i, j)
            sys.exit()
        count += 1  