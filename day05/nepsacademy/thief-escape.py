# I managed to solved this problem but there must be a better way
# It was already brain teasing to think about these constraints and
# certainly there must be something to overcome this...

def solve(h, p, f, d):
    if f < p and f < h:
        if (p < h and d == -1) or (h < p and d == 1):
            return 'S'
        else:
            return 'N'

    if p < h and p < h:
        if (f < h and d == 1) or (h < f and d == -1):
            return 'S'
        else:
            return 'N'

    if h < p and h < f:
        if (p < f and d == 1) or (f < p and d == -1):
            return 'S'
        else:
            return 'N'

DATA = [int(e) for e in input().split()]
print(solve(*DATA))
