from python.online.model import Product
from python.servic import ProductService


def create_prod():
    p_id = int(input("Enter Product Id: "))
    p_name = str(raw_input("Enter Product Name: "))
    price = float(input("Enter Product Price: "))
    p_type = str(raw_input("Enter Product Description: "))
    prod = Product.Product(p_id, p_name, price, p_type)
    return prod


def create_product():
    msg_flag = False
    prod_list = []
    while True:
        prod = create_prod()
        choice = str(raw_input("Do you want enter more: Y/N")).lower()
        prod_list.append(prod)
        print prod_list
        if choice in ["n", "no"]:
            msg_flag = ProductService.create_product(prod_list)
            break
    if msg_flag:
        print "Data Inserted"
    else:
        print "Data not Inserted"


def update_product():
    return None


def delete_product():
    return None


def show_all_products():
    all_data=ProductService.get_all_products()
    for p in all_data:
        print p
    return ProductService.get_all_products()


def get_product():
    return None


def start():
    print "Choose below services"
    print "1.create Product"
    print "2. Show all Product"
    print "3. Get Product using Key"
    print "4. update Product"
    print "5. Delete Product"

    choice = input("Choose above Option:")
    if choice == 1:
        create_product()
    elif choice == 2:
        show_all_products()
    elif choice == 3:
        get_product()
    elif choice == 4:
        update_product()
    else:
        delete_product()


# delete()


if __name__ == '__main__':
    start()
