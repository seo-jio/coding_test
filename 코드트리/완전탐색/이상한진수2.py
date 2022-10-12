import sys

def solve(nums):
    max_sum = -sys.maxsize
    for i in range(len(nums)):
        if nums[i] == '1':
            nums = nums[:i] + "0" + nums[i+1:]
        else:
            nums = nums[:i] + "1" + nums[i+1:]
        max_sum = max(max_sum, cal(nums))
        if nums[i] == '1':
            nums = nums[:i] + "0" + nums[i+1:]
        else:
            nums = nums[:i] + "1" + nums[i+1:]
    return max_sum


def cal(nums):
    total_sum = 0
    for i in range(len(nums)):
        total_sum += 2**(len(nums)-1-i) * int(nums[i])
    return total_sum


nums = input()
ans = solve(nums)
print(ans)