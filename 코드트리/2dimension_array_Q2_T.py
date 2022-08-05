n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]
b = [list(map(int, input().split())) for _ in range(n)]
c = [[1 for _ in range(m)] for _ in range(n)]

for row in range(n):
    for element in range(m):
        if a[row][element] == b[row][element]:
            c[row][element] = 0
for row in c:
    for element in row:
        print(element, end=' ')
    print()
