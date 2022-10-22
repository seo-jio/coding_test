A = input()
count = 0

for i in range(len(A)):
    if A[i] == "(":
        for k in range(i+1, len(A)):
            if A[k] == ")":
                count += 1

print(count)