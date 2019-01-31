is_even = lambda a: a & 1 == 0

def color(a, b):
    if (not is_even(a) and not is_even(b)) or (is_even(a) and is_even(b)):
        return 1
    return 0

L = int(input())
C = int(input())
print(color(L, C))
