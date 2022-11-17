import math
from collections import deque

T = int(input())

def bfs():
    global ans
    while len(q) != 0:
        cur_num, height = q.popleft()
        if cur_num == n:
            if height >= b and height < ans:
                ans = height
            continue
        #선택
        q.append((cur_num + 1, height + people[cur_num]))

        #선택X
        q.append((cur_num + 1, height))

for tc in range(1, T+1):
    n, b = map(int, input().split())
    people = list(map(int, input().split()))
    ans = math.inf
    q = deque()
    q.append((1, people[0]))
    q.append((1, 0))
    bfs()
    print(ans-b)



