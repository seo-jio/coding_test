#bfs로 하다가 포기
from collections import deque
import math

def swap_num(front, back): #idx가 들어온다.
    global num
    res = num
    t = res[front]
    res[front] = res[back]
    res[back] = t
    res = ''.join(res) #list to string
    return int(res) #string to integer

def bfs():
    global max_num, last
    while len(q) != 0:
        idx, bo, cnt = q.popleft()
        if idx == last:
            continue
        print(idx, bo, cnt)
        if idx == last - 1: #종료 조건
            if cnt == t_cnt:
                print(choose)
                res = swap_num(choose[0], choose[1])
                print(f"res : {res}")
                max_num = max(max_num, res)
        if bo == 1 and cnt <= 2:
            print(f"choose:{idx}")
            choose.append(idx)
        q.append((idx+1, 1, cnt+1))
        q.append((idx+1, 0, cnt))


T = int(input())
for tc in range(1, T+1):
    num, t_cnt = map(int, input().split())
    max_num = num
    num = list(str(num)) #문자열로 변환
    last = len(num)
    q = deque()
    q.append((0, 1, 1))
    q.append((0, 0, 0))
    choose = []

    for i in range(t_cnt):
        bfs()
        print(max_num)
