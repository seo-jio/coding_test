import sys

grid = [
    list(map(int, sys.stdin.readline().split()))
    for _ in range(19)
]

dxs = [-1, 0, 1, 1, 1, 0, -1, -1]
dys = [1, 1, 1, 0, -1, -1, -1, 0]

def in_range(x, y ):
    return x >= 0 and x < 19 and y >= 0 and y < 19

def solve(x, y):
    for x in range(19):
        for y in range(19):
            if grid[x][y] == 1 or grid[x][y] == 2:
                for dx, dy in zip(dxs, dys): #8개 방향으로 이동
                    flag = 1
                    for i in range(1, 5): #네 번 움직인다.
                        nx, ny = x + dx * i, y + dy * i
                        if in_range(nx, ny) == False or grid[nx][ny] != grid[x][y]: #격자 범위 밖이거나 다른 돌일 경우
                            flag = 0
                            break #이 경우 네 번까지 움직일 필요가 없으므로  break
                    if flag == 1:
                        print(grid[x][y])
                        print(f"{x + dx*2 + 1} {y + dy*2 + 1}")
                        return
    print(0)

solve(0, 0)
