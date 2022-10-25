for test_case in range(10):
    n = int(input())
    grid = [
        list(map(int, input().split()))
        for _ in range(100)
    ]
    max_row, max_col, max_cross_left, max_cross_right = 0, 0, 0, 0
    sum_col = [0] * 100
    for r in range(100):
        sum_row = 0
        for c in range(100):
            sum_row += grid[r][c]
            sum_col[c] += grid[r][c]
        max_row = max(max_row, sum_row)
    max_col = max(sum_col)

    for i in range(50):
        max_cross_right += grid[50+i][50-i] + grid[50-i][50+i]
        max_cross_left += grid[50-i][50-i] + grid[50+i][50+i]

    print(f"#{test_case+1} {max(max_row, max_col, max_cross_left, max_cross_right)}")
