n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

#주어진 범위를 돌며 동전 개수를 센다
def cal_coin(row_s, row_e, col_s, col_e):
    coin = 0
    for row in range(row_s, row_e + 1):
        for col in range(col_s, col_e + 1):
            if arr[row][col] == 1:
                coin += 1
    return coin

max_coin = 0
for i in range(n):
    for k in range(n):
        if i + 2 >= n or k + 2 >= n: #격자를 넘지 않는지 판단
            continue
        else:
            coin = cal_coin(i, i+2, k, k+2)
            if coin >= max_coin:
                max_coin = coin
print(max_coin)

#수행시간은 O(n^2)