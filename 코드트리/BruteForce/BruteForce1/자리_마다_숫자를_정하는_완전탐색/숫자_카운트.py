n = int(input())
cases = [] #가능한 수들
count = 0

for i in range(n):
    # num, c1, c2 = map(int, input().split())
    cases.append(list(map(int, input().split())))

def is_possible(i, j, k):
    for case in cases:
        num, c1, c2 = case[0], case[1], case[2]
        count1, count2 = 0, 0
        first = num // 100 #첫 번째 자리
        second = num % 100 // 10 #두 번째 자리
        third = num % 10 #세 번째 자리
        if first == i: #or로 묶어줄 경우 first, second, third가 다 일치해도 count1이 1밖에 증가하지 않는다.
            count1 += 1
        else:
            if i == second or i == third:
                count2 += 1
        if second == j:
            count1 += 1
        else:
            if j == first or j == third:
                count2 += 1
        if third == k:
            count1 += 1
        else:
            if k == first or k == second:
                count2 += 1
        if count1 != c1 or count2 != c2:
            return False
    return True


for i in range(1 ,10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i == j or j == k or i == k:
                continue
            else:
                if is_possible(i, j, k) == True:
                    count += 1

print(count)