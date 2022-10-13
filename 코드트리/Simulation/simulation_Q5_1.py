n, m, t = map(int, input().split())

arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

#현재 구슬 위치를 격자에 저장
cur_pos = [
    [0 for _ in range(n)]
    for _ in range(n)
]
for i in range(m):
    x, y = map(int, input().split())
    x, y = x - 1, y - 1
    cur_pos[x][y] = 1

#상하좌우 순으로 dxs,dys를 구성하여 우선순위를 순서대로 부여
dxs = [-1, 1, 0, 0]
dys = [0, 0, -1, 1]

#격자 내에 있는지 판단
def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

#구슬이 충돌한 경우 처리
def re_dup():
    global m
    for i in range(n):
        for k in range(n):
            if next_pos[i][k] > 1:
                m -= next_pos[i][k]
                next_pos[i][k] = 0

#cur_pos와 next_pos를 일치 시킨다.
def same():
    for i in range(n):
        for k in range(n):
            cur_pos[i][k] = next_pos[i][k]


for i in range(t):
    next_pos = [  #구슬의 다음 위치를 저장할 격자
        [0 for _ in range(n)]
        for _ in range(n)
    ]
    for x in range(n):
        for y in range(n):
            if cur_pos[x][y] == 1:  #구슬이 있는 경우
                max_val = 0
                for dx, dy in zip(dxs, dys): #상하좌우 모두 확인
                    nx, ny = x + dx, y + dy
                    if in_range(nx, ny) and max_val < arr[nx][ny]:
                        max_val = arr[nx][ny]
                        tep = (nx, ny)
                nx, ny = tep
                next_pos[nx][ny] += 1 #구슬의 다음 위치를 next_pos 격자에 저장
    re_dup()
    same()

print(m)