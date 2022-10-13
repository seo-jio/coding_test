T = int(input())
count = 0


grid = [
    [0] * T
    for _ in range(T)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    global T
    return x >= 0 and x < T and y >= 0 and y < T

def solve(test_case, x, y):
    if count == T * T:
        return
    x, y = 0, 0
    grid[x][y] = count
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny):
            x, y = nx, ny
            count += 1
            break
    solve(test_case, nx, ny)

for test_case in range(1, T + 1):
    solve(test_case, 0, 0)

for row in grid:
    for elem in row:
        print(elem, end=" ")
    print()