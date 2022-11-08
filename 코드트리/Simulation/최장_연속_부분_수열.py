n, t = map(int, input().split())
arr = list(map(int, input().split()))

max_cnt = 0
cnt = 0
for a in arr:
    if a > t:
        cnt += 1
    else:
        cnt = 0
    max_cnt = max(max_cnt, cnt)

print(max_cnt)