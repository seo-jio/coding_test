temp = [list(map(int, input().split())) for _ in range(4)]
count = 1
sum = 0
for i in range(len(temp)):
    for k in range(count):
        sum += temp[i][k]
    count += 1
print(sum)