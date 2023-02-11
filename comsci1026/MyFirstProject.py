"""
s = "Hello, this is my first program!"
print(s)

#a is a string value
a = "5"
#n is a int value
n = 2
#print s value n times (String repetition)
f = a*n
print(f)

#print(a+n) #this does not work 
print(a+a) #but this works

#line breaker
print()

#getting string input
someText = input("Enter some text: ") #by default input command gets a string value
print("the text you've input is '", someText, "'")

#line breaker
print()

#getting number input
aNumber = input("Enter an interger number: ")
aNumber = int(aNumber) #parsing as an integer
numberSum = aNumber + n
print ("the sum of " , aNumber , " and " , n , " is " , numberSum)

#line break
print()

#importing 
from math import sqrt

from sqlalchemy import true
x = sqrt(25)
print (x)

#string concatenation(+)
firstName = "Luke "
lastName = "Jang"
fullName = firstName + lastName
print(fullName)

#getting a char from string
print("initial is: ", firstName[0], ".", lastName[0])

#using methods 
print("name in all upper case", fullName.upper())

#double quote and single quote
print("asdfa'dafsasfaf")
print('asdfasf"asdfasdf')

#replace
print (fullName.replace("Luke", "Hoyeon"))

#If statement
actualFloor = 0

if floor > 13 :
    actualFloor = floor - 1
else :
    actualFloor = actualFloor - 1
"""
"""
#while loop
asdfv = 1
asdf = 5
while asdfv <= asdf:
    print(asdfv)
    asdfv += 1

#make this to for loop!
StateName = "Virginia"
i = 0
while i < len(stateName):
    letter = stateName[i]
    print(letter)
    i = i + i

#While loop version
i = 1

while i < 10 :
    print(i)
    i = i + 1


#for loop version
# i is automatically defined
for i in range (1, 10):
    print(i)

#i: 0-5
for i in range (6):
    print(i)

#i: 10-15
for i in range (10, 16):
    print(i)

#i:0, 2, 4, 6
for i in range (0, 8, 2):
    print(i)

#i: 5,4,3,2,1
for i in range (5, 0 , -1):
    print(i)



for i in range(0,10,2):
    print(i, end=",")
print()
"""

#nested loop
#making a program to print exponential table

NMAX = 4
XMAX = 10

for n in range(0,NMAX):
    print("%10.0d" % n, end="")

print(                          )

print("/n","    ","-"*35)

#print table body.
for x in range (1,XMAX+1):
    for n in range(1, NMAX+1):
        print("%10.0d" % x ** n, end="")
    print()
