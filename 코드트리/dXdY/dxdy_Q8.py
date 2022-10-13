# 1행 1열 부터 시작
n, m = map(int, input().split())
arr = [[0 for _ in range(n)] for _ in range(n)]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]


def in_range(x, y): #격자 안에 있는지 판단
    return 0 <= x and x < n and 0 <= y and y < n


def is_comfort(x, y): #편안한 상태인지 판단
    count = 0
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and arr[nx][ny] == 1:
            count += 1
    if count == 3: #상하좌우 다 확인 후 체크한 곳이 3개이면 True return
        return True
    else:
        return False

for i in range(m):
    r, c = map(int, input().split())
    r, c = r - 1, c - 1 #인덱스가 0부터 시작하기 때문에 -1씩 해준다.
    arr[r][c] = 1
    if is_comfort(r, c):
        print(1)
    else:
        print(0)
