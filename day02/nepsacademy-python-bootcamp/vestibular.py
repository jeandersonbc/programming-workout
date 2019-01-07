N = input()

A = input()
B = input()
score = 0
for i in range(len(A)):
    if A[i] == B[i]:
        score += 1

print(score)
