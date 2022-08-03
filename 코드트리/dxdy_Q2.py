n = input()

dir_num = 3
#동남서북
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

x, y = 0, 0

for i in range(len(n)):
    if n[i] == "R":
        dir_num = (dir_num + 1) % 4
    elif n[i] == "L":
        dir_num = (dir_num - 1 + 4) % 4
    else:
        x, y = x + dx[dir_num], y + dy[dir_num]

print(x, y)
