class Person:
    def __init__(self,name,age):
        self.name=name
        self.age=age

    def show(self):
        print "Show Person Details"
    def rev(self,name):
        st=""
        for i in range(len(name),0,-1):
            st=st+name[i-1]
        print("kkk:  "+st)

    def list_fr(self):
        fr=["apple","banana"]
        map(lambda n:n[::-1],fr)


p1=Person("Abc",123)

print p1.age
del p1.age
p1.age=10
print p1.age
print p1.name



p1.show()
p1.rev("abc")

p1.list_fr()