d1 = int(input())
h1 = int(input())
m1 = int(input())

d2 = int(input())
h2 = int(input())
m2 = int(input())

delta_d = d2 - d1
delta_h = h2 - h1
delta_m = m2 - m1

print((delta_m * 60) + (delta_h * 3600) + (delta_d * 24 * 3600))
