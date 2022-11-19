from itertools import combinations
import math

n, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

people = set()
hos = set()
for x in range(n):
    for y in range(n):
        if grid[x][y] == 2:
            hos.add((x, y))
        elif grid[x][y] == 1:
            people.add((x, y))

min_total = math.inf
for tup in combinations(hos, m):
    # print(f"tup : {tup}")
    dic = {}
    for x2, y2 in tup:
        for x1, y1 in people:
            dis = abs(x2 - x1) + abs(y2 - y1)
            if (x1, y1) not in dic:
                dic[(x1, y1)] = dis
            dic[(x1, y1)] = min(dic[(x1, y1)], dis)
    # print(people)
    temp_total = 0
    for val in dic.values():
        temp_total += val
    min_total = min(min_total, temp_total)
print(min_total)
