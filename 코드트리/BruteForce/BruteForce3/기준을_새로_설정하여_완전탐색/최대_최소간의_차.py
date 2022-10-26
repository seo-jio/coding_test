import sys

n, k = map(int, input().split())
arr = list(map(int, input().split()))

def cal_cost(i):
    cost = 0
    for a in arr:
        if i <= a <= i + k: #범위 안에 있을 경우
            continue
        elif a < i:
            cost += i - a
        else:
            cost += a - (i+k)
    return cost

min_cost = sys.maxsize
for i in range(1, 10000 + 1): #문제에서 주어진 범위를 제발 잘 좀 보자....
    cost = cal_cost(i)
    min_cost = min(min_cost, cost)
print(min_cost)