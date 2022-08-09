n, m = map(int, input().split())
nums = list(map(int, input().split()))
arr = []
max_result = 0

def cal_xor(): #선택된 값들로 xor 연산 실행
    result = arr[0]
    for i in range(1, m):
        result = result ^ arr[i]
    return result

def solve(cur_num, count):
    global max_result
    if cur_num == n+1:
        if count == m:
            max_result = max(max_result, cal_xor())
        return

    #선택되는 경우
    arr.append(nums[cur_num-1])
    solve(cur_num+1, count+1)
    arr.pop()

    #선택되지 않는 경우
    solve(cur_num+1, count)

solve(1, 0)
print(max_result)