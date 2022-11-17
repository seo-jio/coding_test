import math

T = int(input())

def solve(cur_num, height):
    global ans
    if cur_num == n:
        if height >= b and height < ans:
            ans = height
        return
    #선택
    solve(cur_num+1, height+people[cur_num])

    #선택X
    solve(cur_num+1, height)

for tc in range(1, T+1):
    n, b = map(int, input().split())
    people = list(map(int, input().split()))
    ans = math.inf
    solve(0, 0)
    print(ans-b)



