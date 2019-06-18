import math


def start(A, B):
    in_list = range(A, B)
    in_list.reverse()
    temp_list = []
    for i in in_list:

        sq = math.sqrt(i)
        if sq % 2 == 0:
            in_list = [sq]
            temp_list.append(sq)
            in_list.append(sq)
            continue

    print temp_list
    return len(temp_list)


def main(A, B):
    list_data = range(A, B)
    list_data.reverse()
    res_list = []

    def get(num):
        res = math.sqrt(num)
        if res % 2 == 0:
            list_data.append(res)
            res_list.append(res)
            get(res)

    map(lambda x: get(x), list_data)
    print res_list
    print len(set(res_list))


if __name__ == '__main__':
    A = 6000
    B = 7000
    res = main(A, B)
    print res
