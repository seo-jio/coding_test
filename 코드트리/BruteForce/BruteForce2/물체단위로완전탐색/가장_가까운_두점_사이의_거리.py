import sys

n = int(input())
arr = []
for i in range(n):
    arr.append(tuple(map(int, input().split())))
min_dis = sys.maxsize

for i in range(n):
    for j in range(i+1, n):
        x1 = arr[i][0]
        y1 = arr[i][1]
        x2 = arr[j][0]
        y2 = arr[j][1]
        dis = (x1 - x2)**2 + (y1-y2)**2
        min_dis = min(min_dis, dis)

print(min_dis)