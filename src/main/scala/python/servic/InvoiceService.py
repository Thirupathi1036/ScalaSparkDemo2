def generate_invoice(item_list, cust_data):
    file_name = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/invoice/" + str(
        cust_data.cust_name) + ".txt"
    ff = open(file_name, "w+")
    try:
        repeat = 5
        space_len = 20
        empty_space_len = 125
        pId = "Product Id"
        pName = "Product Name"
        pprice = "Product Price"
        pDesc = "Product Description"
        pQuantity = "Quantity"
        price_amount = "Price"

        ff.write("|" + "-" * empty_space_len + "|")
        ff.write("\n")
        ff.write("| Customer Name: " + str(cust_data.cust_name) + " " * 45 + " Addres:".center(60, " ") + " |")
        ff.write("\n")
        ff.write("|" + " " * empty_space_len + "|")
        ff.write("\n")
        ff.write("|" + " " * empty_space_len + "|")
        ff.write("\n")
        ff.write("|" + "-" * empty_space_len + "|")
        ff.write("\n")
        ff.write(
            "|" + str(pId).center(space_len, " ") + "|" + str(pName).center(space_len, " ") + "|" + str(pprice).center(
                space_len, " ") + "|" + str(pDesc).center(space_len, " ") + "|" + str(pQuantity).center(space_len,
                                                                                                        " ") + "|" + str(
                price_amount).center(space_len, " ") + "|")
        ff.write("\n")
        ff.write("|" + "-" * empty_space_len + "|")
        ff.write("\n")
        for item in item_list:
            ff.write("|" + str(item[0]).center(space_len, " ") + "|" + str(item[1]).center(space_len, " ") + "|" \
                     + str(item[2]).center(space_len, " ") + "|" + str(item[3]).center(space_len, " ") + "|" \
                     + str(1).center(space_len, " ") + "|" + str(item[2] * 1).center(space_len, " ") + "|")
            ff.write("\n")
        if len(item_list) <= 5:
            for i in range(0, repeat - len(item_list)):
                ff.write(
                    "|" + "".center(space_len, " ") + "|" + "".center(space_len, " ") + "|" + "".center(space_len,
                                                                                                        " ") + "|" + "".center(
                        space_len, " ") + "|" + "".center(space_len, " ") + "|" + "".center(space_len, " ") + "|")
                ff.write("\n")
        ff.write("|" + "-" * empty_space_len + "|")
        ff.write("\n")
        ff.write("|" + " " * 92 + "Total Amount|" + str(get_total_price(item_list)).center(space_len, " ") + "|")
        ff.write("\n")
        ff.write("|" + "-" * empty_space_len + "|")
        print "Invoice Generated .....!"
    except Exception as ex:
        print "Oops... Invoice Not Generated? "
    finally:
        ff.close()


def get_total_price(list_item):
    price = map(lambda data: data[2], list_item)
    if len(price) != 0:
        pp = reduce(lambda a, b: float(a) + float(b), price)
        return pp
    else:
        0.0
