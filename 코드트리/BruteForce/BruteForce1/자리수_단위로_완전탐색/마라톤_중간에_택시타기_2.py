import sys

n = int(input())
points = []
for i in range(n):
    points.append(tuple(map(int, input().split())))
min_dis = sys.maxsize

def cal_dis(jump): #jump = 건너뛰는 idx
    total_dis = 0
    for i in range(1, n):
        if i == jump:
            continue
        elif i == jump + 1:
            x1, y1 = points[i - 2]  # 점프한 직후일 경우
            x2, y2 = points[i]
        else:
            x1, y1 = points[i - 1]  # 점프하지 않은 경우
            x2, y2 = points[i]
        total_dis += abs(x1 - x2) + abs(y1 - y2)
    return total_dis

for i in range(1, n-1):
    min_dis = min(min_dis, cal_dis(i))
print(min_dis)
