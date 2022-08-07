target = input()
part = input()

def is_part(t):
    flag = 1
    for p in range(len(part)):
        if target[t+p] != part[p]:
            flag = 0
    if flag == 1:
        return True
    else:
        return False

def solve():
    if target == part:
        return 0
    for t in range(len(target) - len(part) + 1):
        if is_part(t):
            return t
    return -1

print(solve())