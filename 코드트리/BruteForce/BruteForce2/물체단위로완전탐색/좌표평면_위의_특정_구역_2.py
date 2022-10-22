n = int(input())
arr = []
for i in range(n):
    arr.append(tuple(map(int, input().split())))
min_area = 40000 * 40000 #넓이가 될 수 있는 최대값

for i in range(n):
    temp = arr[:i] + arr[i+1:]
    max_x = max(temp, key=lambda x: x[0])[0] #max(temp, key=lambda x: x[0])가 최대 x를 갖는 튜플을 return한다.
    min_x = min(temp, key=lambda x: x[0])[0]
    max_y = max(temp, key=lambda x: x[1])[1]
    min_y = min(temp, key=lambda x: x[1])[1]
    area = (max_x - min_x) * (max_y - min_y)
    min_area = min(min_area, area)

print(min_area)