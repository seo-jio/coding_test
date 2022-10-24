n = int(input())
arr = list(input())


def findDis(temp):
    pos = []
    for idx, elem in enumerate(temp):
        if elem == '1':
            pos.append(idx)
    dis = []
    for i in range(1, len(pos)):
        dis.append(pos[i] - pos[i-1])
    return min(dis)

max_dis = 0
for i in range(n):
    temp = arr[:]
    if temp[i] == '1':
        continue
    temp[i] = '1'
    print(temp)
    dis = findDis(temp[:])  # temp를 매개변수로 넘겨줌
    print(dis)
    max_dis = max(max_dis, dis)
print(max_dis)