n = int(input())
pos = [-1] * 11
arr = [
    tuple(map(int, input().split()))
    for _ in range(n)
]

count = 0
for num, line in arr:
    if pos[num] == -1:
        pos[num] = line
    else:
        if pos[num] != line:
            count += 1
            pos[num] = line

print(count)