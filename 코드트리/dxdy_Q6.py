n = int(input())

dir_dict = {
    "E": 0,
    "S": 1,
    "W": 2,
    "N": 3
}

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]
x, y = 0, 0

time = 0
ans = 0
flag = 0  #시작지점에 여러번 도달 할 경우 가장 처음에 도달하는 값인지를 판단하기 위해 사용
for i in range(n):
    dir_c, dist = input().split()
    dist = int(dist)
    dir_num = dir_dict[dir_c]
    for k in range(dist):
        dx, dy = dxs[dir_num], dys[dir_num]
        x, y = x + dx, y + dy
        time += 1
        # print(f"x,y : {x}, {y}")
        if x == 0 and y == 0 and flag == 0:
            ans = time
            flag = 1
if ans == 0:
    print(-1)
else:
    print(ans)
