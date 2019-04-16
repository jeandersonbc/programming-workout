# budget
n = int(input())

# demand
x = int(input())
y = int(input())
z = int(input())


# Let's just be greedy to maximize the demand
vals = sorted([x, y, z])

total = 0
for v in vals:
    if v <= n:
        n -= v
        total += 1

print(total)
