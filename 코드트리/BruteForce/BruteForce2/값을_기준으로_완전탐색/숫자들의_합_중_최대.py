def is_pelindrome(num):
    string = str(num)
    if len(string) % 2 == 0:
        print(1)
        front = string[:len(string)//2] 
        back = string[len(string)//2:]
        print(front)
        print(back)
        back = back[::-1] #문자열 뒤집기
    else:
        print(2)
        front = string[:len(string)//2]
        back = string[len(string)//2 + 1:]
        back = back[::-1]
    if front == back:
        return True
    return False

print(is_pelindrome(100001))