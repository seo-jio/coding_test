def insertionSort():
    for i in range(1, len(arr)):
        j = i - 1
        key = arr[i]
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j+1] = key

n = int(input())
arr = list(map(int, input().split()))
insertionSort()
for a in arr:
    print(a, end=" ")