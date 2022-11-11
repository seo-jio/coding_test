def cal(count):
    global a
    if count == 0:
        return 1
    else:
        return a * cal(count-1)

T = 10
for t in range(T):
    tc = int(input())
    a, count = map(int, input().split())
    ans = cal(count)
    print(f"#{tc} {ans}")