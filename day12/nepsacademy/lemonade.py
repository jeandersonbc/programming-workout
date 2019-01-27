N, C = input().split()
N = int(N)
C = int(C)

total = 0
for i in range(N):
    value = (C - i) if (C - i) >= 1 else 1
    total += value

print(total)
