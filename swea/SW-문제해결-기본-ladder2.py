import math

def in_range(x, y):
    return x >= 0 and x < 100 and y >= 0 and y < 100

def cal(i):
    x, y = 0, i
    dxs = [1, 0, 0]
    dys = [0, 1, -1]
    dir_num = 0
    cnt = 1
    while x != 99:
        # print(x, y)
        if dir_num == 0:
            if in_range(x, y+1) and grid[x][y+1]:
                next_dir_num = 1
            elif in_range(x, y-1) and grid[x][y-1]:
                next_dir_num = 2
            elif in_range(x+1, y) and grid[x+1][y]:
                next_dir_num = dir_num
            else:
                return 0
        elif dir_num == 1:
            if in_range(x+1, y) and grid[x+1][y]:
                next_dir_num = 0
            elif in_range(x, y+1) and grid[x][y+1]:
                next_dir_num = dir_num
            else:
                return 0
        else:
            if in_range(x+1, y) and grid[x+1][y]:
                next_dir_num = 0
            elif in_range(x, y-1) and grid[x][y-1]:
                next_dir_num = dir_num
            else:
                return 0

        dir_num = next_dir_num
        x, y = x + dxs[dir_num], y + dys[dir_num]
        cnt += 1
    return cnt

T = 10
for t in range(T):
    tc = int(input())
    grid = [
        list(map(int, input().split()))
        for _ in range(100)
    ]
    ans = -1
    min_cnt = math.inf
    for i in range(100):
        if grid[0][i] != 0:
            result = cal(i)
            if result:
                if min(min_cnt, result) == result:
                    ans = i
                    min_cnt = min(min_cnt, result)
    print(f"#{tc} {ans}")
