x = int(input())

if x == 1:
    print(1)

prev = 1 #1초 동안 갈 수 있는 최대 거리
for t in range(2, 1000): #t초에 갈 수 있는 최대 거리를 계산
    temp = 0
    if t % 2 != 0: # t가 홀수일 떄
        for i in range(1, t // 2 + 1):
            temp += i * 2
        temp += t // 2 + 1
    else:
        for i in range(1, t // 2 + 1):
            temp += i * 2
    if prev < x <= temp:
        print(t)
        break
