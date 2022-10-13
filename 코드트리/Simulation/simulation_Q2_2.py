n, t = map(int, input().split())
arr = [
    list(map(int, input().split()))
    for _ in range(3)
]
for i in range(t):
    temp = []
    for k in range(0, 3):  #미는 방향 쪽 마지막 값을 temp 리스트에 append
        temp.append(arr[k][-1])

    for k in range(n-2, -1, -1):  #한 칸씩 오른 쪽으로 shift
        arr[0][k+1] = arr[0][k]
        arr[1][k+1] = arr[1][k]
        arr[2][k+1] = arr[2][k]

    for k in range(0, 3):  #첫번째 칸에 저장해둔 temp 값을 알맞게 넣어줌
        if k == 0:
            arr[0][0] = temp[-1]
        else:
            arr[k][0] = temp[k-1]

for row in arr:
    for elem in row:
        print(elem, end=' ')
    print()