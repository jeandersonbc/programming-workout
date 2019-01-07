S = input()

R = ""
for c in S:
    if c in "aeiou":
        R += c

print('S' if R == R[::-1] else 'N')
