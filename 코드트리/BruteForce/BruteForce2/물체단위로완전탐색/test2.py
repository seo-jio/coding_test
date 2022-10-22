arr = [(2, 0), (4, 2), (8, 1), (6, 3), (12, 5)]

for i in range(len(arr)):
    temp = arr[:]
    print(arr)
    print(temp)
    print(arr is temp)
    print(temp[i][0] is arr[i][0])
    print("========")
