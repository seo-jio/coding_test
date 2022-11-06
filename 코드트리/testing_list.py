from collections import Counter

value = "Hello Appia"

countValue = Counter(value)

for key, value in countValue.items():
    print(f"{key}:{value}", end=' ')
