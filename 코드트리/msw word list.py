from collections import defaultdict

arr = list(input().split(', '))
print(arr)
print(len(arr))
dic = defaultdict(list)
for elem in arr:
    dic[len(elem)].append(elem)
print(dic)
