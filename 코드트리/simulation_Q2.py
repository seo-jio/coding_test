n, t = map(int, input().split())
up = list(map(int, input().split()))
down = list(map(int, input().split()))

#아랫줄을 뒤집으려고 생각하지 말고 아랫줄의 이동 모습을 보면 왼쪽으로  shift이지만
#인덱스를 기준으로 보면 2, 1, 0 순서대로 나열 된 채 왼쪽으로 밀리는 모습이므로
#결국 오른쪽으로 shift한다고 생각하면 된다.


for i in range(t):
    up_temp = up[-1]
    for u in range(n-1, 0, -1): #up 오른쪽으로 shift
        up[u] = up[u-1]
    up[0] = down[n-1]

    for d in range(n-1, 0, -1):  #down 왼쪽으로 shift
        down[d] = down[d-1]
    down[0] = up_temp

for u in up:
    print(u, end=' ')
print()
for d in down:
    print(d, end=' ')