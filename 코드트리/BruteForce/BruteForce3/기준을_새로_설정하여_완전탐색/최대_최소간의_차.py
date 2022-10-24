import sys

n, k = map(int, input().split())
arr = list(map(int, input().split()))
print(arr)

def cal_cost(i):
    cost = 0
    for a in arr:
        if i <= a <= i + k:
            continue
        elif a < i:
            print("first")
            cost += i - a
        else:
            print("third")
            cost += a - (i+k)
    print(f"cost : {cost}")
    return cost

min_cost = sys.maxsize
for i in range(1, 1000 + 1):
    print(f"i : {i}")
    cost = cal_cost(i)
    print("======================")
    min_cost = min(min_cost, cost)
print(min_cost)