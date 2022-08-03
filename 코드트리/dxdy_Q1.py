n = int(input())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

nx, ny = 0, 0

for i in range(n):
    dir, dis = input().split()
    dis = int(dis)
    if dir == "E":
        nx += dx[0] * dis
        ny += dy[0] * dis
    elif dir == "S":
        nx += dx[1] * dis
        ny += dy[1] * dis
    elif dir == "W":
        nx += dx[2] * dis
        ny += dy[2] * dis
    elif dir == "N":
        nx += dx[3] * dis
        ny += dy[3] * dis

print(nx, ny)