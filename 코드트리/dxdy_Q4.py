n, t = map(int, input().split())
x, y, dir_c = input().split()

#행,열이 1행 1열부터 시작하므로 -1 씩 해준다.
x = int(x) - 1
y = int(y) - 1

#입력에 따른 방향 지정
dict_dir = {
    "U": 2,
    "D": 1,
    "R": 0,
    "L": 3
}

dir_num = dict_dir[dir_c]
dxs = [0, 1, -1, 0]
dys = [1, 0, 0, -1]

def in_range(x, y):
    return x >= 0 and x <n and y >= 0 and y < n

for i in range(t):
    nx, ny = x + dxs[dir_num], y + dys[dir_num]

    if in_range(nx, ny):
        x, y = nx, ny
    else:
        dir_num = 3 - dir_num

    # 초기 풀이(가독성이 떨어짐)
    # if not in_range(nx, ny):
    #     dir_num = 3 - dir_num
    #     continue
    # x, y = nx, ny

#정답을 도출할 때는 빼줬던 1을 다시 더해준다.
x = x + 1
y = y + 1

print(x, y)

