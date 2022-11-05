from collections import deque

T = int(input())

dxs = [-1, 1, 0, 0]
dys = [0, 0, -1, 1]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def bfs():
    global count
    while len(deq) != 0:
        x, y = deq.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if in_range(nx, ny) and grid[nx][ny] - grid[x][y] == 1:
                count += 1
                deq.append((nx, ny))
                break

for tc in range(1, T+1):
    n = int(input())
    grid = [
        list(map(int, input().split()))
        for _ in range(n)
    ]


    deq = deque()
    max_count = 0
    max_room_num = n*n

    for x in range(n):
        for y in range(n):
            count = 1
            deq.append((x,y))
            bfs()

            if count > max_count:
                max_room_num = grid[x][y]
            elif count == max_count:
                max_room_num = min(max_room_num, grid[x][y])

            max_count = max(max_count, count)

    print(f"#{tc} {max_room_num} {max_count}")

##Visited 배열을 둘 필요가 없음 -> 무조건 값이 큰 대로만 이동하기 떄문에(값의 차가 1인 경우가 아님)