l = [1, 2, 3, 4, 5]
s = set([6, 7, 8, 9, 0])

c = map(lambda x, y: x + y, l, s)
print c
t1 = map(lambda x, y: (x, y), l, s)
print t1
print type(t1)
zv = zip(l, s)
print zv
