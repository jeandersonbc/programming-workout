N = input()

A = input()
B = input()
score = 0
for a, b in zip(A, B):
    if a == b:
        score += 1

print(score)
