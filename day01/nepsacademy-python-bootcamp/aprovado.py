A, B = input().split()

A = float(A)
B = float(B)
avg = (A + B) / 2

if avg >= 7:
    print("Aprovado")
elif avg >= 4:
    print("Recuperacao")
else:
    print("Reprovado")
