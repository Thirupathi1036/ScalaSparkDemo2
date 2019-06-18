from python.dao import ProductDao


def create_product(prod_list):
    product_list = []
    for prod in prod_list:
        p_list = [str(prod.pId), prod.pName, str(prod.price), prod.pType]
        product_list.extend([p_list])
    if len(product_list) == 0:
        return False
    else:
        print "passing to DAO"
        return ProductDao.create_product(product_list)


def update_product(prod, prodId):
    return 1


def delete_product(pId):
    return 1


def get_product(pId):
    return 1


def get_all_products():
    return ProductDao.get_all_products()
