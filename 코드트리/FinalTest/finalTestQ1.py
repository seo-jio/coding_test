import sys

arr = list(map(int, input().split()))
max_n = -sys.maxsize
min_n = sys.maxsize

for i in range(10):
    if arr[i] < 500:
        if arr[i] > max_n:
            max_n = arr[i]
    else:
        if arr[i] < min_n:
            min_n = arr[i]

print(max_n, min_n)