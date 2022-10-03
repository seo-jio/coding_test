import sys

t = int(input())
arr = []

for i in range(t):
    n = int(input())
    temp = list(map(int, input().split()))
    arr.append(temp)

t = 1
for row in arr:
    count = 0
    min_num = sys.maxsize
    for elem in row:
        if abs(elem) < min_num:
            min_num = abs(elem)
            count = 1
        elif abs(elem) == min_num:
            count += 1
    print(f"#{t} {abs(min_num)} {count}")
    t += 1
