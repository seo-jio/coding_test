n = int(input())
arr = list(input())
pos = []
print(arr)
for idx, elem in enumerate(arr):
    if elem == '1':
        pos.append(idx)

max_dis = 0
left, right = 0, 0
for i in range(1, len(pos)):
    temp = pos[i] - pos[i - 1]
    if temp > max_dis:
        print(temp)
        right = pos[i]
        left = pos[i-1]
    max_dis = max(max_dis, temp)
print(right, left)
pos.append((right + left) // 2)
pos.sort()
print(pos)

min_dis = 1000
for i in range(1, len(pos)):
    temp = pos[i] - pos[i - 1]
    min_dis = min(min_dis, temp)
print(min_dis)