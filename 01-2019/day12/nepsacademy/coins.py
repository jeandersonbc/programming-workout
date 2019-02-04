coins = {100: 0,
         50: 0,
         25: 0,
         10: 0,
         5: 0,
         1: 0}

C = int(input())
curr = 0
for coin in coins.keys():
    if (C // coin > 0):
        coins[coin] = C // coin
        C -= (coin * coins[coin])

num = sum(coins.values())
print(num)
for coin, qtd in coins.items():
    print(qtd)

