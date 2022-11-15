import sys
from collections import defaultdict

N, M, K = map(int, sys.stdin.readline().split())
balls = []
for i in range(M):
    r, c, m, s, d = map(int, sys.stdin.readline().split()) # r, c, m, s, d
    r, c = r-1, c-1
    balls.append((r, c, m, s, d))

def in_range(x, y):
    return x >= 0 and x < N and y >= 0 and y < N

def move(x, y, s, d):
    dxs = [-1, -1, 0, 1, 1, 1, 0, -1]
    dys = [0, 1, 1, 1, 0, -1, -1, -1]
    for i in range(s):
        nx, ny = x + dxs[d], y + dys[d]
        if not in_range(nx, ny):
            nx, ny = (nx + N) % N, (ny + N) % N
        x, y = nx, ny
    return x, y

for time in range(K):
    dic = defaultdict(list)
    for ball in balls:  # 모든 볼들을 이동시킴
        r, c, m, s, d = ball
        r, c = move(r, c, s, d)
        dic[(r, c)].append((m, s, d))
    for key, value in dic.items():
        if len(value) >= 2:
            m, s, dirs = 0, 0, ''
            for v in value:
                m += v[0]
                s += v[1]
                dirs += str(v[2])
            m = m // 5
            s = s // len(value)
            if m == 0: #무게가 0일 경우 삭제
                dic[key] = []
                continue
            if int(dirs[0]) % 2 == 0:
                flag = 0 #처음 수가 짝수
            else:
                flag = 1 #처음 수가 홀수
            for i in range(1, len(dirs)):
                if flag == 0 and int(dirs[i]) % 2 == 1:
                    flag = 3
                elif flag == 1 and int(dirs[i]) % 2 == 0:
                    flag = 3
            dic[key] = []
            if flag == 3:
                d = 1
                for i in range(4):
                    dic[key].append((m, s, d))
                    d += 2
            else:
                d = 0
                for i in range(4):
                    dic[key].append((m, s, d))
                    d += 2

    balls = []
    for key, val in dic.items():
        r, c = key
        for v in val:
            m, s, d = v
            balls.append((r, c, m, s, d))

sum_m = 0
for key, val in dic.items():
    for v in val:
        sum_m += v[0]
print(sum_m)