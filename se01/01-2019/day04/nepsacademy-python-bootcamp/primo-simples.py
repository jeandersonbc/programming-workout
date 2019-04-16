def is_prime(x):
    if x == 1:
        return False

    c = 2
    while (c < x):
        if x % c == 0:
            return False 
        c += 1

    return True

x = int(input())
print('S' if is_prime(x) else 'N')
