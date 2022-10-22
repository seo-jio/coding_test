n, b = map(int, input().split())
prices = []
for _ in range(n):
    prices.append(int(input()))
prices.sort() #정렬

count = 0
for i in range(n):
    temp = prices[:i]
    temp.append(prices[i]//2) #가격이 가장 큰 값을 반으로 나눠 줌
    if sum(temp) > b:
        break
    count += 1

print(count)