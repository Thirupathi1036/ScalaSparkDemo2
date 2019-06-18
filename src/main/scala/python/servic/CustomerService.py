from python.dao import CustomerDao
from python.online.model import Customer


def create(cust):
    cust = str(cust.cust_id) + "," + cust.cust_name

    return CustomerDao.createRecord(cust)


def show():
    file_data = CustomerDao.show_customers()

    return map(lambda rec: Customer.Customer(rec[0], rec[1]), file_data)


def get_customer(in_cust_id):
    try:
        customer_list = show()

        return filter(lambda cust: int(cust.cust_id) == int(in_cust_id), customer_list)[0]
    except Exception as e:
        return "No Record found"


def update(updated_cust_data, cust_id):
    updated_cust = list([str(updated_cust_data.cust_id), updated_cust_data.cust_name])
    CustomerDao.update_Record(updated_cust, cust_id)
    return None


def delete(cust_id):
    return CustomerDao.delete_record(cust_id)
