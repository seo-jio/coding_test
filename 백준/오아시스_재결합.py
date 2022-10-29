n = int(input())
arr = [
    int(input())
    for _ in range(n)
]

def is_possible(start, end):
    limit = min(arr[start], arr[end])
    while start < end:
        print(f"limit : {limit}, arr[start+1]:{arr[start+1]}, arr[end-1]:{arr[end-1]}")
        if arr[start+1] > limit or arr[end-1] > limit:
            return False
        start += 1
        end -= 1
    return True

start, end = 0, n-1
count = 0
for i in range(n//2):
    print(start, end, i)
    if is_possible(start + i, end - i):
        print("pass")
        count += 1
print(count)