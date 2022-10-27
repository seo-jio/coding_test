string = input()
bomb = input()
ans = []

def is_bomb():
    for i in range(len(bomb)):
        if ans[len(ans) - 1 - i] != bomb[len(bomb) - 1 - i]:
            return False
    return True

def cal(string):
    for elem in string:
        ans.append(elem)
        if len(ans) >= len(bomb):
            if is_bomb():
                for i in range(len(bomb)):
                    ans.pop()

    if len(ans) == 0:
        print("FRULA")
    else:
        for a in ans:
            print(a, end="")

cal(string)