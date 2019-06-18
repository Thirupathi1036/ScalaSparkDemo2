from python.controller import CustomerController
from python.servic import ProductService
from python.servic import InvoiceService


def reduce_list(l1, l2):
    print "inside reduce"
    if len(l1) != 0 and len(l2) != 0:
        reduce(lambda l1, l2: l1.extend(l2))
    else:
        []


def buy_product():
    cust = CustomerController.get_customer()

    cart_item_list = []
    if type(cust) == str:
        ""
    else:
        all_prods = ProductService.get_all_products()
        for prod in all_prods:
            print prod
        buy_choice = raw_input("Do you want to buy from above Products (Y/N): ").lower()
        if buy_choice in ["n", "no"]:
            print "Thanks for visiting site"
        else:
            while True:
                p_id = long(input("Add to Cart using Product Id: "))
                item_list = filter(lambda list_prod: int(list_prod[0]) == p_id, all_prods)

                if len(item_list) != 0:
                    item = reduce(lambda l1, l2: reduce_list(l1, l2), item_list)
                    cart_item_list.append(item)
                print cart_item_list
                cart_choice = raw_input("Do you want to Buy more Products (Y/N): ").lower()
                if cart_choice in ["n", "no"]:
                    break
                else:
                    # all_prods = ProductService.get_all_products()
                    update_products = [item for item in all_prods if item not in cart_item_list]
                    if len(update_products) == 0:
                        print "Products are out stock"
                        break
                    print update_products
            print "Tanks for choosing online cart..!\nGenerating Invoice using below products"
            for ci in cart_item_list:
                print ci
            InvoiceService.generate_invoice(cart_item_list, cust)
    return None


def buy_something():
    return None


def start():
    print "Choose below services"
    print "1.Buy Products"

    choice = input("Choose above Option:")
    if choice == 1:
        buy_product()
    else:
        buy_something()


if __name__ == '__main__':
    start()
