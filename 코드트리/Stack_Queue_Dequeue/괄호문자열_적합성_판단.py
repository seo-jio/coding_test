string = input()
stack = []

def is_possible(string):
    for char in string:
        if char == '(':
            stack.append(char)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    if len(stack) != 0:
        return False
    return True

if is_possible(string):
    print("Yes")
else:
    print("No")
