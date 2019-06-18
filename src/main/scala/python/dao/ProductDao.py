file_name = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/customer_data/product_info.txt"


def create_product(prod_list):
    try:
        file = open(file_name, "a+")
        print prod_list
        for prod in prod_list:
            file.write(",".join(prod))
            file.write("\n")
        return True
    except Exception as ex:
        print ex.message
        return False
    finally:
        file.close()


def update_product(prod, prodId):
    return 1


def delete_product(pId):
    return 1


def get_product(pId):
    return 1


def get_all_products():
    try:
        file = open(file_name, "r")
        prod_data_list = file.readlines()
        return map(lambda prod: prod.rstrip().split(","), prod_data_list)
    except Exception as ex:
        print ex.message
        return []
    finally:
        file.close()
