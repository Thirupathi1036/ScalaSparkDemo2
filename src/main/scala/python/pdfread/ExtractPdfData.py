from pdfrw import PdfReader

def start(file_name):
    x = PdfReader(file_name)

    print x.keys()
    print len(x.pages)
    for j in range(len(x.pages))[:2]:
        print x.pages[j].Contents.stream
        print x.pages[j].extractText()
    # kids=x['/Root']['/Pages']['/Kids']
    # for i in kids:
    #     print i
    return None


if __name__ == '__main__':
    file_name = "/Users/thirupathi.c/Downloads/Thiru/pdf/ukpga_20160019_en.pdf"
    start(file_name)
