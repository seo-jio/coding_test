r, c = map(int, input().split())
grid = [
    list(input())
    for _ in range(r)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

for row in grid:
    for elem in row:
        print(elem, end=" ")
    print()