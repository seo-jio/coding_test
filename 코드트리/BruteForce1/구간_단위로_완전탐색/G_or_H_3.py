import sys

n, k = map(int, input().split())
arr = [0] * 10001 #0은 제외하고 1~10000까지 가능
for i in range(n):
    tup = tuple(input().split())
    arr[int(tup[0])] = tup[1]
max_sum = -sys.maxsize

def cal(start):
    total_sum = 0
    for i in range(start, start + k + 1):
        if arr[i] == "G":
            total_sum += 1
        elif arr[i] == "H":
            total_sum += 2
    return total_sum

for i in range(1, len(arr)-k-1):
    max_sum = max(max_sum, cal(i))

print(max_sum)