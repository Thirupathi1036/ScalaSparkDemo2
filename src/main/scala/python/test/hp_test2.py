
n_list=[]
for i in range(20):
    n_list.append(i*i)

print n_list

res_list=filter(lambda n: n%2==0 ,n_list)

print res_list