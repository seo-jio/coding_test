T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    c_arr = [0 for _ in range(101)]
    for a in arr:
        c_arr[a] += 1
    frequent = 0
    max_num = max(c_arr)
    for i in range(len(c_arr)):
        if c_arr[i] == max_num:
            frequent = i
    print(f"#{n} {frequent}")