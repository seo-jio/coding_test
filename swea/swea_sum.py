T = 10
for tc in range(1, T+1):
    no = int(input())
    grid = [
        list(map(int, input().split()))
        for _ in range(100)
    ]
    max_row = 0
    for row in grid:
        max_row = max(max_row, sum(row))

    max_col = 0
    for y in range(100):
        cur = 0
        for x in range(100):
            cur += grid[x][y]
        max_col = max(max_col, cur)

    cross_right = 0
    for i in range(100):
        cross_right += grid[i][i]

    cross_left = 0
    for i in range(100):
        cross_left += grid[i][100-i-1]

    ans = max(max_col, max_row, cross_left, cross_right)
    print(f"#{tc} {ans}")
