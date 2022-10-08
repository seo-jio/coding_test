def heap_sort(n):
    for i in range(n//2, 0, -1): #make heap
        heapify(i, n)
    for k in range(n, 1, -1):
        arr[1], arr[k] = arr[k], arr[1]
        heapify(1, k-1)

def heapify(k, n):
    l = k * 2
    r = k * 2 + 1
    largest = k
    if l <= n and arr[largest] < arr[l]: #방어 조건으로 먼저 l, r이 인덱스 내에 위치하는지 선별
        largest = l
    if r <= n and arr[largest] < arr[r]:
        largest = r
    if largest != k:
        arr[k], arr[largest] = arr[largest], arr[k]
        heapify(largest, n)


n = int(input())
arr = list(map(int, input().split()))
arr.insert(0, 0)
heap_sort(n)
for a in arr[1:]:
    print(a, end=" ")

