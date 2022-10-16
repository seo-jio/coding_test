import sys

n = int(input())
arr = [0] + list(map(int, input().split())) #1번 인덱스 부터 시작
min_dis = sys.maxsize

def cal(idx): # 굳이 나눌 필요가 없었다...
    total_dis = 0
    for i in range(1, idx):
        total_dis += (idx - i) * arr[i]
    for i in range(idx+1, n+1):
        total_dis += abs(idx - i) * arr[i]
    return total_dis

for i in range(1, n+1):
    min_dis = min(min_dis, cal(i))

print(min_dis)