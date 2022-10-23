# arr = [[2, 0], [4, 2], [8, 1], [6, 3], [12, 5]]
arr = [(2, 0), (4, 2), (8, 1), (6, 3), (12, 5)]

# temp = arr[:] #이차원 배열을 복사하는 경우 for문을 활용하자!
# temp[0][0] = 22
# temp[1] = [-1, -1]
# print(temp) #[[22, 0], [4, 2], [8, 1], [6, 3], [12, 5]]
# print(arr) #[[22, 0], [4, 2], [8, 1], [6, 3], [12, 5]]

next_arr = [0] * len(arr)
for i in range(len(arr)):
    next_arr[i] = arr[i][:]
print(next_arr)
