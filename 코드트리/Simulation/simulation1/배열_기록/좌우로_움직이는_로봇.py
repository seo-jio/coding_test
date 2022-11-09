n, m = map(int, input().split())
MAX = 1000001 #1000000까지의 index를 사용할 수 있어야 하므로 1을 더 크게 잡아준다.
A = [0] * MAX
B = [0] * MAX

time = 1
for i in range(n):
    t, d = input().split()
    t = int(t)
    if d == 'R':
        for j in range(t):
            A[time] = A[time - 1] + 1
            time += 1
    else:
        for j in range(t):
            A[time] = A[time - 1] - 1
            time += 1

for i in range(time, MAX):
    A[i] = A[i-1]


time = 1
for i in range(m):
    t, d = input().split()
    t = int(t)
    if d == 'R':
        for j in range(t):
            B[time] = B[time - 1] + 1
            time += 1
    else:
        for j in range(t):
            B[time] = B[time - 1] - 1
            time += 1

for i in range(time, MAX):
    B[i] = B[i-1]

# print(A)
# print(B)

cnt = 0
for i in range(1, len(A)):
    if A[i] == B[i] and A[i-1] != B[i-1]:
        # print(f"i : {i}")
        cnt += 1
print(cnt)
