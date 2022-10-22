import sys

arr = list(map(int, input().split()))
min_diff = sys.maxsize

def cal_diff(i, j, k):
    sum1 = arr[i] + arr[j] + arr[k]
    return abs(sum(arr) - sum1*2)

for i in range(len(arr)):
    for j in range(i+1, len(arr)):
        for k in range(j+1, len(arr)):
            min_diff = min(min_diff, cal_diff(i, j, k))

print(min_diff)