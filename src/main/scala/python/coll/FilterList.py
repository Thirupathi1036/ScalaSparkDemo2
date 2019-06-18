l_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]

res_list = filter(lambda n: n % 2 == 0, l_list)

d_list = map(lambda n: n * 2, l_list)

n_list = filter(lambda n: n == 2, l_list)

print res_list

print d_list

print n_list
