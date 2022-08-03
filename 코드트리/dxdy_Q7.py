n = input()
x, y = 0, 0

#동남서북
dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]
dir_num = 3

flag = 1
time, ans = 0, 0
for i in range(len(n)):
    time += 1
    if n[i] == "F":
        dx, dy = dxs[dir_num], dys[dir_num]
        x, y = x + dx, y + dy
        if x == 0 and y == 0 and flag == 1:
            ans = time
            flag = 0
    elif n[i] == "R":
        dir_num = (dir_num + 1) % 4
    else:
        dir_num = (dir_num - 1 + 4) % 4

if ans == 0:
    print(-1)
else:
    print(ans)