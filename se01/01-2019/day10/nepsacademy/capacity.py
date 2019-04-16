C = int(input())
A = int(input())

trips = 0
remaining = A
while (remaining > 0):
    remaining -= (C - 1)
    trips += 1

print(trips)
