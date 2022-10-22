import copy

n, b = map(int, input().split())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]
max_count = 0

for i in range(n):
    #temp = copy.deepcopy(arr)
    temp = arr[:]
    print(arr)
    print(temp)
    temp[i][0] = temp[i][0] // 2
    temp.sort(key=lambda x:x[0]+x[1])
    temp_sum = [tup[0]+tup[1] for tup in temp]

    cur_sum = 0
    count = 0
    for j in range(n):
        if cur_sum + temp_sum[j] > b:
            break
        cur_sum += temp_sum[j]
        count += 1
    max_count = max(max_count, count)

print(max_count)