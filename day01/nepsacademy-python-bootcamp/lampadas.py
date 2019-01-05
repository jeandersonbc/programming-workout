N = int(input())
SEQ = [e for e in input().split()]

A = False
B = False
for s in SEQ:
    if s == '1':
        A = not A
    else:
        A = not A
        B = not B

print(int(A))
print(int(B))
