T = 10
for tc in range(1, T+1):
    n, num = input().split()
    n = int(n)
    ans = [num[0]]
    for i in range(1, n):
        if ans and ans[-1] == num[i]:
            ans.pop()
        else:
            ans.append(num[i])
    print(f"#{tc} {''.join(ans)}")