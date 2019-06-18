res_list = set(['.cis', '.trans', '.trans[0].id[0].num1', '.trans[0].id[0]', '.trans[0].id', '.trans[1].id',
                '.trans[0].id[0].num2'])
out_list = []
out_dict = {}

for i in res_list:

        for k in res_list:
            print "i: ", i, k
            if len(k) != len(i) and k.startswith(i) and k not in out_list:
                out_list.append(k)
            if "[" not in i and i not in out_list:
                out_list.append(i)
        # elif len(k) != len(i) and k not in i:
        #     print k

print out_list
