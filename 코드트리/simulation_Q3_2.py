n = int(input())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

r, c = map(int, input().split())
r, c = r-1, c-1

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

dxs = [-1, 0, 1, 0]
dys = []

# 폭탄 터뜨리기
def bomb():
    for x in range(n):
        for y in range(n):
            if x == r and y == c:
                # arr[r][c] 값에 알맞게 0으로 상하좌우 칸을 바꿔 줌
                # 처음에는 arr[r][c]라고 썼는데 r,c는 x,y와 같은 걸 가리키므로 x,y 하나로만 사용해야 실수를 막을 수 있다.
                for i in range(1, arr[x][y]):
                    if in_range(x-i, y):
                        arr[x-i][y] = 0
                    if in_range(x, y+i):
                        arr[x][y+i] = 0
                    if in_range(x+i, y):
                        arr[x+i][y] = 0
                    if in_range(x, y-i):
                        arr[x][y-i] = 0
                arr[x][y] = 0  #이걸 마지막에 해줘야 위 for문에 arr[r][c]값을 읽어 올 수 있다.

# 중력 작용(하나의 열에 적용)
def gravity(col):
    temp = [
        [0 for _ in range(n)]
        for _ in range(n)
    ]
    temp_row = n-1
    for row in range(n-1, -1, -1):
        if arr[row][col] != 0:
            temp[temp_row][col] = arr[row][col]
            temp_row -= 1
    for row in range(n):
        arr[row][col] = temp[row][col]

bomb()
for col in range(n): #모든 열을 돌며 중력 작용
    gravity(col)

for row in arr:
    for elem in row:
        print(elem, end=' ')
    print()