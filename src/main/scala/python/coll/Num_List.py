n_list = [1, 2, 4, 3, 4, 5, 6, 7, 7, 8, 9]

n_list.reverse()
print n_list

print n_list.count(7)
n_list.append(11)
print n_list
print n_list.index(3)

n_list.sort()
print n_list
n_list.insert(2, 20)
print n_list

n_list.pop(2)
print n_list
print set(n_list)
print list(dict.fromkeys(n_list))
n_list.remove(9)
print n_list
print n_list[::-1]

print filter(lambda x: x % 2 == 0, n_list)



