n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
visited = [
    [False for _ in range(n)]
    for _ in range(n)
]

def cal_coin(row, col_s, col_e):
    coin = 0
    for col in range(col_s, col_e + 1):
        if arr[row][col] == 1:
            coin += 1
    return coin

def second_block(r, c):
    second_max_c = 0
    for k in range(c+3, n): #첫 번째 블록과 같은 행에 존재
        if k + 2 >= n:
            break
        else:
            second_coin = cal_coin(r, k, k + 2)
            if second_max_c < second_coin:
                second_max_c = second_coin

    for i in range(r+1, n): #첫 번째 블록 다음 행에 존재
        for k in range(n):
            if k + 2 >= n:
                continue
            else:
                second_coin = cal_coin(i, k, k + 2)
                if second_max_c < second_coin:
                    second_max_c = second_coin
    return second_max_c

max_sum = 0
max_coin = 0
for i in range(n):
    for k in range(n):
        if k + 2 >= n:
            continue
        else:
            coin = cal_coin(i, k, k+2)
            if coin > max_coin:
                max_coin = coin
                second_max_coin = second_block(i, k)
                temp_sum = max_coin + second_max_coin
                if temp_sum > max_sum:
                    max_sum = temp_sum

print(max_sum)


# max_c = max(coins)
# max_count = coins.count(max_c)
#
# if max_count >= 2:
#     second_max_c = max_c
# else:
#     coins.remove(max_c)
#     second_max_c = max(coins)
#
# print(coins)
# print(max_c+second_max_c)
