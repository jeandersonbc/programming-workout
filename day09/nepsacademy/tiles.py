L = int(input())
C = int(input())

# This one only requires some math to figure the patterns
type1 = (L * C) + ((L - 1) * (C - 1))
type2 = ((L - 1) * 2) + ((C - 1) * 2)

print(type1)
print(type2)
