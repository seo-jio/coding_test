# arr = [(2, 0), (4, 2), (8, 1), (6, 3), (12, 5)]
# arr.sort(key=lambda x:x[0]+x[1])
# print(arr)
#
# temp = [tup[0]+tup[1] for tup in arr]
# print(temp)
# print(sum(temp))

arr = [(2, 0), (4, 2), (8, 1), (6, 3), (12, 5)]
temp = arr[:]
print(temp is arr)
print(temp[0] is arr[0])