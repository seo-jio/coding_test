import sys

n, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

dir_num = 0
dxs = [1, 0, -1, 0]
dys = [0, 1, 0, -1]

#인접한 3개의 블록을 선택하여 숫자의 합을 최대가 되는 경우를 찾는다.

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def find_max(x, y): #상하좌우 살피며 최대 합 구하기
    max_num = -sys.maxsize
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and grid[nx][ny] > max_num:
            max_num = grid[nx][ny]



