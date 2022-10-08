def merge_sort(low, high): #반식 쪼갠 후 병합하는 함수
    if low < high:
        mid = (low + high) // 2
        merge_sort(low, mid)  #왼쪽 배열
        merge_sort(mid + 1, high) #오른쪽 배열
        merge(low, mid, high) #병합

def merge(low, mid, high): #두 리스트를 병합하는 함수
    i = low
    j = mid + 1
    k = low
    while i <= mid and j <= high:
        if arr[i] < arr[j]:
            merged_arr[k] = arr[i]
            i += 1
            k += 1
        else:
            merged_arr[k] = arr[j]
            j += 1
            k += 1

    while i <= mid:
        merged_arr[k] = arr[i]
        i += 1
        k += 1

    while j <= high:
        merged_arr[k] = arr[j]
        j += 1
        k += 1

    for m in range(low, high + 1): #merged_arr을 전체 다 돌 필요 없이 low~high까지만 돌면된다.
        arr[m] = merged_arr[m]

n = int(input())
arr = list(map(int, input().split()))
merged_arr = [0 for _ in range(len(arr))]  # 정렬된 값을 넣을 배열, 초기에 한 번만 생성하면 된다.
merge_sort(0, len(arr)-1)
for a in arr:
    print(a, end=" ")