
class Car:
    def __init__(self):
        self._type = ""
    
    def setType(self, type):
        self._type = type
    
    def getType(self):
        return self._type
    

#create three cars
c1 = Car()
c2 = Car()
c3 = Car()

#Set their type
c1.setType("Toyota")
c2.setType("Honda")
c3.setType("Nissan")

#print the type
print(c1.getType())
print(c2.getType())
print(c3.getType())




class Coffee:
    def __init__(self):
        self._cost = 2.50
    
    def __add__(self, other):
        if isinstance(other, Cream):
            return "Yum"
    
class Cream:
    def __init__(self):
        self._percent=10

coffee = Coffee()
cream = Cream()

print(coffee + cream)



class CashRegister:

    def addItem(self, price):
        self._itemCount = self._itemCount + 1
        self._totalPrice = self._totalPrice + price
    
    def clear(self):
        self._itemCount = 0
        self.totalPrice = 0.0
    
    def getTotal(self):
        return self._totalPrice