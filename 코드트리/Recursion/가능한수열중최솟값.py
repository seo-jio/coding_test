import sys

n = int(input())
nums = [4, 5, 6]
series = []

def is_possible():
    last = len(series) - 1
    for i in range(len(series)):
        start1, end1 = last - i, last
        start2, end2 = start1 - 1 - i, start1 - 1
        if start2 < 0:
            break
        if series[start2:end2+1] == series[start1:end1+1]:
            return False
    return True

def solve(cur_num):
    global n
    if cur_num == n:
        for s in series:
            print(s, end="")
        sys.exit()
    for num in nums:
        series.append(num)
        if is_possible():
            solve(cur_num + 1)
        series.pop()

solve(0)