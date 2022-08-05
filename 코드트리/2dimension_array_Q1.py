temp = [list(map(int, input().split())) for _ in range(4)]
for i in range(len(temp)):
    print(sum(temp[i]))