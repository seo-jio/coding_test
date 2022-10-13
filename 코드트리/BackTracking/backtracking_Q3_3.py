import sys

n = int(input())
nums = list(map(int, input().split()))

groupA = []
groupB = []

cur_num = 1
cnt = 0
min_sub = sys.maxsize

def cal_sub():
    groupA_sum = 0
    # print(groupA)
    for i in range(len(groupA)):
        if groupA[i] == 1:
            groupA_sum += nums[i]
    total_sum = sum(nums)
    groupB_sum = total_sum - groupA_sum
    return abs(groupA_sum - groupB_sum)

def combination(cur_num, cnt):
    global min_sub
    if cnt == n: # cur_num이 2*n이 되기 이전에 뽑은 숫자가 두 개인 경우 바로 두 그룹의 차이를 계산하여 가지치기를 수행
            min_sub = min(min_sub, cal_sub())

    if cur_num == 2*n + 1:
        return

    groupA.append(1)
    combination(cur_num+1, cnt+1) #선택되는 경우(1)
    groupA.pop()

    groupA.append(0)
    combination(cur_num+1, cnt) #선택되지 않은 경우(0)
    groupA.pop()

combination(1, 0)
print(min_sub)