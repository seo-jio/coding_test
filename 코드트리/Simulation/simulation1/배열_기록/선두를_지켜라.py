n, m = map(int, input().split())
A, B = [], []
for i in range(n):
    v, t = map(int, input().split())
    for j in range(t):
        A.append(v)

for i in range(m):
    v, t = map(int, input().split())
    for j in range(t):
        B.append(v)

dis_a, dis_b = 0, 0
front = 0
for i in range(len(A)):
    dis_a += A[i]
    dis_b += B[i]
    if dis_a > dis_b:
        front = 1
    else:
        front = 2
    break


cnt = 0
dis_a, dis_b = 0, 0
for i in range(len(A)):
    dis_a += A[i]
    dis_b += B[i]
    if front == 1:
        if dis_b > dis_a:
            cnt += 1
            front = 2
    else:
        if dis_a > dis_b:
            cnt += 1
            front = 1
print(cnt)
