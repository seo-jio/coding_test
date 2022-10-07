def bubbleSort():
    global n
    size = n
    while True:
        flag = True
        for i in range(size-1):
            if lis[i] > lis[i+1]:
                temp = lis[i]
                lis[i] = lis[i+1]
                lis[i+1] = temp
                flag = False
        if flag == True:
            break

n = int(input())
lis = list(map(int, input().split()))
bubbleSort()
for l in lis:
    print(l, end=' ')