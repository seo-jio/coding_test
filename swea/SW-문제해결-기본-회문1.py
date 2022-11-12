T = 10

def in_range(x, y):
    return x >= 0 and x < 8 and y >= 0 and y < 8

for tc in range(1, T+1):
    n = int(input())
    grid = [
        list(input())
        for _ in range(8)
    ]

    cnt = 0
    for x in range(8):
        for y in range(8):
            row = ""
            if in_range(x+(n-1), y):
                for i in range(n):
                    row += grid[x+i][y]
                if row == row[::-1]:
                    cnt += 1
            col = ""
            if in_range(x, y+(n-1)):
                for i in range(n):
                    col += grid[x][y+i]
                if col == col[::-1]:
                    cnt += 1
    print(f"#{tc} {cnt}")
