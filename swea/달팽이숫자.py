T = int(input())

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def solve(n):
    grid = [
        [0] * n
        for _ in range(n)
    ]
    x, y = 0, 0
    dir_num = 0
    count = 1

    while count <= n*n:
        grid[x][y] = count
        nx, ny = x + dxs[dir_num], y + dys[dir_num]
        if not in_range(nx, ny) or grid[nx][ny] != 0:
            dir_num = (dir_num + 1) % 4
            nx, ny = x + dxs[dir_num], y + dys[dir_num]
        x, y = nx, ny
        count += 1

    for row in grid:
        for elem in row:
            print(elem, end=" ")
        print()


for test_case in range(1, T + 1):
    n = int(input())
    print(f"#{test_case}")
    solve(n)

