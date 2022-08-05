n, m = map(int, input().split())

temp = [[0 for _ in range(m)] for _ in range(n)]
start = 1
for i in range(n):
    for k in range(m):
        temp[i][k] = start
        start += 1

for row in temp:
    for element in row:
        print(element, end=' ')
    print()
