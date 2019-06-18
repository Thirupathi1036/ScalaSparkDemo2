from python.online.model import Customer
from python.servic import CustomerService


def create_Customer():
    c_id = int(input("Enter Cutsomer Id: "))
    c_name = str(raw_input("Enter Customer Name: "))
    cust = Customer.Customer(c_id, c_name)
    return cust


def create():
    while True:
        cust = create_Customer()
        CustomerService.create(cust)
        choice = str(raw_input("Do you want enter more: Y/N")).lower()
        print choice
        if choice in list(["n", "no"]):
            break


def show():
    data = CustomerService.show()
    if len(data) == 0:
        print "No Data exist"
    else:
        for d in data:
            print str(d.cust_id) + " " + d.cust_name
    return None


def get_customer():
    cust_id = input("Enter Customer Id: ")
    customer = CustomerService.get_customer(cust_id)
    if type(customer) == str:
        print customer
        return customer
    else:
        print customer.cust_id + " " + customer.cust_name
        return customer
    # return None


def update(del_flag=False):
    msg = "No Record found"
    cust_id = input("Enter Customer Id: ")
    customer = CustomerService.get_customer(cust_id)
    if type(customer) == str:
        return customer

    else:
        print "Customer Found with Id: ", cust_id
        if del_flag:
            msg = CustomerService.delete(cust_id)
            return msg
        else:
            updated_cust_data = create_Customer()
            msg = CustomerService.update(updated_cust_data, cust_id)
            return msg
    return msg


def delete():
    msg = update(True)
    print msg
    return None


def start():
    print "Choose below services"
    print "1.create Customer"
    print "2. Show all Customers"
    print "3. Get Customer using Key"
    print "4. update Customer"
    print "5. Delete Customer"

    choice = input("Choose above Option:")
    if choice == 1:
        create()
    elif choice == 2:
        show()
    elif choice == 3:
        get_customer()
    elif choice == 4:
        update()
    else:
        delete()


if __name__ == '__main__':
    start()
