# box dimensions
a = int(input())
b = int(input())
c = int(input())

# window dimensions
h = int(input())
l = int(input())

# Helps to find the best side of the box
dims = sorted([a, b, c])

# If it doesn't fit this way, has to fit the other
if (dims[0] <= l and dims[1] <= h) or (dims[0] <= h and dims[1] <= l):
    print('S')

# ..Otherwise it's just impossible...
else:
    print('N')
