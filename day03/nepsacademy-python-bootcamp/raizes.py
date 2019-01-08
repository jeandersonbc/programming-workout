from math import sqrt

# Unnecessary
N = input()

nums = [float(a) for a in input().split()]
for num in nums:
    print("{:.4f}".format(sqrt(num)))

