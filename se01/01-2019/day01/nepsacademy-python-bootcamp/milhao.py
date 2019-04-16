N = int(input())
total = 0
for i in range(N):
    total += int(input())
    if total >= 1000000:
        print(i + 1)
        break

