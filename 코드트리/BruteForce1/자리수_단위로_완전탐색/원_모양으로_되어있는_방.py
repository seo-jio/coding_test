import sys

n = int(input())
rooms = [0]
for i in range(n):
    rooms.append(int(input()))
min_dis = sys.maxsize

#이동 거리 = idx 차이
def cal_dis(start):
    total_dis = 0
    for i in range(1, n+1):
        if i < start:  #시작 방 보다 앞에 있을 경우
            total_dis += (n-start+i) * rooms[i]
        elif i > start: #시작 방 보다 뒤에 있을 경우
            total_dis += (i - start) * rooms[i]
    return total_dis

for i in range(1, n+1):
    min_dis = min(min_dis, cal_dis(i))
print(min_dis)

