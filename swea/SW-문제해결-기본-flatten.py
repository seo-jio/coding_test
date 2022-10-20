def dump():
    min_num = min(boxes)
    max_num = max(boxes)
    min_idx = boxes.index(min_num)
    max_idx = boxes.index(max_num)
    if max_num - min_num <= 1:
        return max_num - min_num
    boxes[min_idx] += 1
    boxes[max_idx] -= 1
    return -1

for test_case in range(1, 11):
    n = int(input()) # 덤프횟수
    boxes = list(map(int, input().split()))
    ans = -1
    for i in range(n):
        temp = dump()
        if temp != -1:
            ans = temp
            break
    if ans != -1:
        print(f"#{test_case} {ans}")
    else:
        min_num = min(boxes)
        max_num = max(boxes)
        print(f"#{test_case} {max_num-min_num}")