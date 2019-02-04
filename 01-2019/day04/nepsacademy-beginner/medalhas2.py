# Other version for 'medalhas.py'
#
# This one is straightforward and requires only to enumerate the outcomes.
# With a good editor, it wouldn't take long to type.
# The drawback is that a more complex problem with more more inputs
# would require to enumerate all cases. No thanks :P

t1 = int(input())
t2 = int(input())
t3 = int(input())


if t1 < t2 and t1 < t3:
    print(1)
    if t2 < t3:
        print(2)
        print(3)
    else:
        print(3)
        print(2)
elif t2 < t3 and t2 < t1:
    print(2)
    if t1 < t3:
        print(1)
        print(3)
    else:
        print(3)
        print(1)
else:
    print(3)
    if t1 < t2:
        print(1)
        print(2)
    else:
        print(2)
        print(1)
