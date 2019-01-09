def fatorial(N):
    if N == 0 or N == 1:
        return 1
    return fatorial(N - 1) * N

N = int(input())
print(fatorial(N))

