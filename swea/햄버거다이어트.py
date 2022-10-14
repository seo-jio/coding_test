T = int(input())

def solve(cur_num):
    global point_sum
    if cur_num == N+1:
        total_calorie = 0
        for i in range(len(temp)):
            if temp[i] == 1:
                total_calorie += arr[i][1]
        if total_calorie <= L:
            temp_sum = 0
            for i in range(len(temp)):
                if temp[i] == 1:
                    temp_sum += arr[i][0]
            # print(f"temp : {temp}")
            # print(f"point_sum : {point_sum} / temp_sum : {temp_sum}")
            point_sum = max(point_sum, temp_sum)
        return

    for i in range(2):
        temp.append(i)
        solve(cur_num+1)
        temp.pop()

for test_case in range(T):
    N, L = map(int, input().split())
    # print(f"N, L : {N}, {L}")
    arr = []  # (점수, 칼로리)
    for i in range(N):
        arr.append(tuple(map(int, input().split())))
    temp = []
    point_sum = 0
    solve(1)
    print(f"#{test_case+1} {point_sum}")


