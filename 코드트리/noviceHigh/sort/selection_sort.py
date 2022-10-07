import sys

def selectionSort():
    for i in range(len(li)):
        min_num = li[i]
        min_index = i
        for j in range(i+1, len(li)):
            if li[j] < min_num:
                min_index = j
                min_num = li[min_index]
        temp = li[i]
        li[i] = li[min_index]
        li[min_index] = temp

n = int(input())
li = list(map(int, input().split()))
selectionSort()
for l in li:
    print(l, end=" ")