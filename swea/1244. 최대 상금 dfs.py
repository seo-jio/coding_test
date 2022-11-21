#테케 2개 통과 못함
import math

def swap_num(front, back): #idx가 들어온다.
    res = k[:]
    t = res[front]
    res[front] = res[back]
    res[back] = t
    res = ''.join(res) #list to string
    return int(res) #string to integer

def solve(idx, cnt):
    global max_num
    if idx == last:
        if cnt == 2:
            # print(choose)
            res = swap_num(choose[0], choose[1])
            if res not in s:
                s.add(res)
                te_numbers.append(res)
                # if res != max_num:
                max_num = max(max_num, res)
        return
    choose.append(idx)
    solve(idx+1, cnt+1)
    choose.pop()
    solve(idx+1, cnt)

T = int(input())
for tc in range(1, T+1):
    num, t_cnt = map(int, input().split())
    s = set()
    s.add(num)
    max_num = -math.inf
    times = 0
    numbers = [num]
    while times != t_cnt:
        # print(numbers)
        te_numbers = []
        for n in numbers:
            # print(f"times:{times}, n:{n}")
            k = list(str(n)) #문자열로 변환
            last = len(k)
            choose = []
            solve(0, 0)
            # print(f"max_num : {max_num}")
        numbers = te_numbers
        times += 1
    print(f"#{tc} {max_num}")

