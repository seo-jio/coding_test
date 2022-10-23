string = "100001"
front = string[:len(string)//2]
back = string[len(string)-1:len(string)//2-1:-1]
print(front)
print(back)