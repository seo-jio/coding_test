T = 10
for tc in range(1, T+1):
    n = int(input())
    grid = [
        list(map(int, input().split()))
        for _ in range(n)
    ]
    cnt = 0
    for y in range(n):
        prev = -1
        for x in range(n):
            cur = grid[x][y]
            if prev == - 1 and cur != 0:
                prev = cur
                continue
            if cur != 0:
                if prev == 1 and cur == 2:
                    cnt += 1
                prev = cur
    print(f"#{tc} {cnt}")





