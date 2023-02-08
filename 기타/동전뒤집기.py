t = int(input())
arr = []
for i in range(t):
    arr.append(input())

#1 앞면, 0 뒷면
for i in range(t):
    temp = ""
    for _ in range(len(arr[i])):
        temp += "0"
    count = 0
    while True:
        # print(f"arr[i] = {arr[i]}, temp = {temp}")
        if arr[i] == temp:
            break
        for a in range(len(arr[i])):
            if arr[i][a] != temp[a]:
                t = temp[:a] + arr[i][a]
                for _ in range(len(temp[a+1:])):
                    t += arr[i][a]
                temp = t
                count += 1
    print(f"#{i+1} {count}")