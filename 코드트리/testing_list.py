n, m = map(int, input().split())
x, y = 0, 0

#시계 방향 순서로 지정
dir_num = 0
dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

count = 1
arr = [[0 for _ in range(m)] for _ in range(n)]
arr[0][0] = count

#격자 안에 있는 지 확인
def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m


while count != n*m:
    count += 1
    nx, ny = x + dxs[dir_num], y + dys[dir_num]

    #다음 이동할 위치가 격자 안에 있는지 먼저 확인 후, 격자 안에 있다면 이미 갔던 곳인지 확인
    if not in_range(nx, ny) or arr[nx][ny] != 0:
        dir_num = (dir_num + 1) % 4  #방향을 바꿔줌
        nx, ny = x + dxs[dir_num], y + dys[dir_num]

    x, y = nx, ny
    arr[x][y] = count

for row in arr:
    for elem in row:
        print(elem, end=' ')
    print()

