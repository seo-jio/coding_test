import sys

n = int(input())
arr = [
    tuple(map(int, input().split()))
    for _ in range(n)
]

min_num = arr[0][0]
max_num = arr[0][1]
for i in range(1, n):
    if arr[i][0] > max_num or arr[i][1] < min_num:
        print("No")
        sys.exit()
    else:
        min_num = min(min_num, arr[i][0])
        max_num = max(max_num, arr[i][1])
print("Yes")