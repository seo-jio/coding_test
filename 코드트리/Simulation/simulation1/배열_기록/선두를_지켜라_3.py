MAX = 1000001

n, m = map(int, input().split())
A, B = [0] * MAX, [0] * MAX

time = 1
for i in range(n):
    v, t = map(int, input().split())
    for j in range(t):
        A[time] = A[time -1] + v
        time += 1

time = 1
for i in range(m):
    v, t = map(int, input().split())
    for j in range(t):
        B[time] = B[time -1] + v
        time += 1

# print(A)
# print(B)

hall = []
for i in range(1, len(A)):
    if A[i] > B[i]:
        hall.append('A')
    elif A[i] < B[i]:
        hall.append('B')
    else:
        hall.append('AB')

cnt = 0
for i in range(1, len(hall)):
    if hall[i] != hall[i-1]:
       cnt += 1
print(cnt)