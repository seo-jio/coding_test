T = int(input())
for tc in range(1, T+1):
    a = input()
    nums = list(map(int, input().split()))
    counter = [0] * 101
    for n in nums:
        counter[n] += 1

    max_num = max(counter)
    ans = 0
    for i, v in enumerate(counter):
        if v == max_num:
            ans = i
    print(f"#{tc} {ans}")