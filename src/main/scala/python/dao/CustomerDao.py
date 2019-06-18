file_name = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/customer_data/cust_info.txt"


def createRecord(data):
    try:
        ff = open(file_name, "a+")
        ff.write(data)
        ff.write("\n")
        return "Record inserted"
    except Exception as e:
        print e.message
        return "Record Not inserted"
    finally:
        ff.close()


def update_Record(updated_cust_data, cust_id, del_flag=False):
    msg = "No Data Updated"
    customer_list = show_customers()
    try:

        if del_flag:
            for cust in customer_list:
                if int(cust[0]) == int(cust_id):
                    customer_list.remove(cust)
        else:
            for cust in customer_list:
                if int(cust[0]) == int(cust_id):
                    customer_list.remove(cust)
                    customer_list.extend([updated_cust_data])

        flag = write_customer_list(file_name, customer_list)
        if flag == 1:
            msg = "Data Updated"
            return msg
        else:
            return msg
    except Exception as ex:
        flag = write_customer_list(file_name, customer_list)
        if flag == 1:
            msg = "Data Updated"
            return msg
        else:
            return msg
    finally:
        return msg


def delete_record(cust_id):
    return update_Record(None, cust_id, True)


def show_customers():
    try:
        ff = open(file_name, "r")
        res = ff.readlines()
        return map(lambda rec: rec.rstrip().split(","), res)
    except Exception as ex:
        return []
    finally:
        ff.close()


def write_customer_list(file_name, customer_list):
    try:
        ff = open(file_name, "w+")
        for cust in customer_list:
            ff.write(",".join(cust))
            ff.write("\n")
        return 1
    except Exception as ex:
        print ex.message
        return 0
    finally:
        ff.close()


def load():
    data = [['111', 'abc'], ['112', 'thiru'], ['113', 'pathi'], ['114', 'thirupathi'], ['120', 'abi'], ['121', 'Welm'],
            ['130', 'karthik'], ['140', 'akir'], ['142', 'nam'], ['131', 'Ram'], ['132', 'laxm'], ['135', 'Niraj'],
            ['151', 'Rk'], ['8', 'l'], ['161', 'Niraj'], ['162', 'komal'], ['181', 'abc'], ['1001', 'Delete']]
    try:
        ff = open(file_name, "w+")
        for dd in data:
            ff.write(",".join(dd))
            ff.write("\n")
        print "data loaded"
    except Exception as ex:
        print ex.message
    finally:
        ff.close()


if __name__ == '__main__':
    load()
