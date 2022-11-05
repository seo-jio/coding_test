from collections import deque

n, k = map(int, input().split())
order = []

def cal(n, k):
    dq = deque()
    for i in range(1, n+1): #큐 초기화
        dq.append(i)
    while len(dq) != 0:
        for i in range(k-1):
            dq.append(dq.popleft())
        order.append(dq.popleft())

cal(n, k)
for o in order:
    print(o, end=" ")
