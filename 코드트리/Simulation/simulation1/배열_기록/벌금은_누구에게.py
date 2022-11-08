n, m, k = map(int, input().split())
penalty = [0] * (n+1)
order = [
    int(input())
    for _ in range(m)
]

ans = -1
for i in range(m):
    student = order[i]
    penalty[student] += 1
    if penalty[student] >= k:
        ans = student
        break

print(ans)