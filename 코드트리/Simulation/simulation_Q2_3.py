n, m, q = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

winds = []
for i in range(q):
    r, d = input().split()
    winds.append((int(r), d))

def shift_right(row):
    temp = grid[row][-1]
    for i in range(m-1, 0, -1):
        grid[row][i] = grid[row][i - 1]
    grid[row][0] = temp

def shift_left(row):
    temp = grid[row][0]
    for i in range(1, m):
        grid[row][i-1] = grid[row][i]
    grid[row][-1] = temp

for row, s_direction in winds:
    start = row - 1
    if s_direction == 'R': #바람에 의한 영향
        direction = 'R'
        shift_left(start)
    else:
        direction = 'L'
        shift_right(start)

    for row in range(start-1, -1, -1): #아래쪽 전파
        flag = 0
        for col in range(m): #전파 이전 가능한 지 확인
            if grid[row][col] == grid[row+1][col]:
                flag = 1
                break
        if flag == 1:
            if direction == 'L':
                shift_left(row)
                direction = 'R'
            else:
                shift_right(row)
                direction = 'L'
        else:
            break

    direction = s_direction
    for row in range(start+1, n):
        flag = 0
        for col in range(m):  # 전파 이전 가능한 지 확인
            if grid[row][col] == grid[row-1][col]:
                flag = 1
                break
        if flag == 1:
            if direction == 'L':
                shift_left(row)
                direction = 'R'
            else:
                shift_right(row)
                direction = 'L'
        else:
            break

for row in grid:
    for elem in row:
        print(elem, end=' ')
    print()
