# This version can be easily extended to a more general
# scenario for multiple inputs by just changing the range value for the input reading.
#
ORD = {}

# Here, I read the times, and keep the index for later
for i in range(3):
    T = int(input())
    ORD[T] = i + 1

# Now I sort the read times
SEQ = sorted(ORD.keys())

# Since the ordered list SEQ represents the classification,
# I just need to show the original index of the given entry
for time in SEQ:
    print(ORD[time])

# Funny that I just jumped into this way of thinking rather than enumerate all
# the cases. Perhaps I was biased because I am familiar with dictionaries.
