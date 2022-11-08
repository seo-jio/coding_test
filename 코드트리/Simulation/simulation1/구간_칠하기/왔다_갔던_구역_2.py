n = int(input())
lines = [0] * 2001
segments = []

pos = 0
for i in range(n):
    dis, dir = input().split()
    dis = int(dis)
    if dir == 'R':
        left = pos
        right = pos + dis
        pos += dis
    else:
        right = pos
        left = pos - dis
        pos -= dis
    segments.append([left, right])


for s in segments:
    left, right = s
    left, right = left + 1000, right + 1000
    for i in range(left, right): #가장 오른쪽 칸을 빼준다
        lines[i] += 1

cnt = 0
for l in lines:
    if l >= 2:
        cnt += 1
print(cnt)