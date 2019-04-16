import re
N = input()

# some cleanup
data = re.sub('\s+', '', input())

# replace target pattern by a flag 'x' and count the frequency of flag
print(len([e for e in re.sub('100', 'x', data) if e == 'x']))
