T = 10
for tc in range(1, T+1):
    n, num = input().split()
    n = int(n)
    cur = 0
    while cur < n-1:
        print(num[cur], num[cur+1], cur, n)
        if num[cur] == num[cur+1]:
            num = num[:cur] + num[cur+2:]
            cur -= 1
            n -= 2
        else:
            cur += 1
    print(f"#{tc} {num}")
