T = int(input())
for tc in range(1, T+1):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    ans = 0
    if m == max(n, m):
        for i in range(m-n+1):
            cur = 0
            for j in range(n):
                cur += A[j] * B[i+j]
            ans = max(cur, ans)
    else:
        for i in range(n-m+1):
            cur = 0
            for j in range(m):
                cur += B[j] * A[i+j]
            ans = max(cur, ans)

    print(f"#{tc} {ans}")