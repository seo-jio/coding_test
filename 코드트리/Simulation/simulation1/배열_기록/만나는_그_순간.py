n, m = map(int, input().split())
A, B = [None], [None]
for i in range(n):
    d, t = input().split()
    for j in range(int(t)):
        A.append(d)


for i in range(m):
    d, t = input().split()
    for j in range(int(t)):
        B.append(d)

# print(A)
# print(B)
# print("-----------")

res_A, res_B = [0], [0]

ans = -1
for i in range(1, len(A)):
    if A[i] == 'R':
        res_A.append(res_A[i-1] + 1)
    else:
        res_A.append(res_A[i-1] - 1)
    if B[i] == 'R':
        res_B.append(res_B[i-1] + 1)
    else:
        res_B.append(res_B[i-1] - 1)
    if res_A[i] == res_B[i]:
        ans = i
        break
    # print(i)
    # print(res_A)
    # print(res_B)
    # print("============")


print(ans)