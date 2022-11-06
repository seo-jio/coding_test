T = int(input())

for tc in range(1, T+1):
    n = int(input())
    grid = [
        input()
        for _ in range(n)
    ]

    # for row in grid:
    #     for elem in row:
    #         print(elem, end=' ')
    #     print()

    # print(grid[0])

    if n == 1:
        print(f"#{tc} {grid[0][0]}")
    else:
        ans = 0
        start, end = n//2, n//2
        for x in range(0, n // 2 + 1):
            # print(f"{start}, {end}")
            for y in range(start, end + 1):
                # print(f"(x,y) : ({x},{y})")
                ans += int(grid[x][y])
            start, end = start - 1, end + 1

        start, end = n // 2, n // 2
        for x in range(n-1, n//2, -1):
            for y in range(start, end + 1):
                ans += int(grid[x][y])
            start, end = start - 1, end + 1
        print(f"#{tc} {ans}")

