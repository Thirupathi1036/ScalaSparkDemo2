names1 = ["a", "b", "c", "d"]
names2 = ["f", "g"]

all_name = names1 + names2
print all_name

print reduce(lambda a, b: (a + b), all_name)
print reduce(lambda x, y: x + y, [1, 2, 3, 4, 5])

print filter(lambda nn: nn == "a", all_name)

print max(2, 1)
print max(1, 2)

print min(1, 2)
print min(2, 1)
