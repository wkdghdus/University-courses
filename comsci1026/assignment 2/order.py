# Name: order.py
# By Hoyeon Luke Jang
# Date: October 26th, 2022
# Description: A program which takes in a order, and creates a list.
 

#Import pizzaReceipt.py to order.py use its function
from pizzaReceipt import generateReceipt 

### declaring and initializing constant. 

##CONSTANTS
#tuple of offered toppings
TOPPINGS = ("ONION", "TOMATO", "GREEN PEPPER", "MUSHROOM", "OLIVE", "SPINACH", "BROCCOLI", "PINEAPPLE", "HOT PEPPER", "PEPPERONI", "HAM", "BACON", "GROUND BEEF", "CHICKEN", "SAUSAGE")
#tuple of available size
SIZE = ('S', 'M', 'L', 'XL')

##VARIABLES
temp = ""               #temporary variable to evaluate the input before saving the list
pizza = []              #empty list to save individual pizza info, it will be appended as a tuple to pizzas list #size in index 0 and toppings in index 1
toppings = []           #empty list of toppings
pizzas = []             #empty list to save a ordered pizza as a tuple
continueOrder = True    #boolean variable to see if the user wants to continue ordering

###getting input
##asking if the user wants to order pizza
temp = input("Do you want to order a pizza? ")

#if the user wants to order pizza, enter the ordering process, if not proceed to last step (sending the created list to generateReceipt function)
if not (temp.upper() == "NO" or temp.upper() == "Q"):   
    ##The process will loop until the user wants to stop ordering
    while continueOrder:

        ##Getting the size
        #if the temp value is not a valid size
        while not (temp in SIZE):
            print("")   #line breaker
            ##getting the size of the pizza
            temp = input("Choose a size: S, M, L, XL: ")
            temp = temp.upper()     #makes input case insensitive (not specified in the assignment, but needed to pass the test)

        #adding the valid size into the pizza list
        pizza.append(temp)

        
        ##Getting toppings
        #loop until the user stop adding toppings (When the input is "X" or "x")
        while (not temp == "X"):
            #getting input
            print("Type in one of our toppings to add it to your pizza. To see the list of toppings, enter \"LIST\". When you are done adding toppings, enter \"X\"")
            temp = input()

            #converting input to all uppercase for further use
            temp = temp.upper()

            #checking the user input and running the following input
            if temp in TOPPINGS:            #if the topping is valid
                #print and append the added topping
                print("Added %s to your pizza" % (temp))
                toppings.append(temp)
            elif (temp.upper() == "LIST"):  #if the user asks for a list of toppings
                #print the toppings tuple 
                print(TOPPINGS)
            else:                           # if the input is invalid
                if not (temp.upper() == "X"):
                    print("Invalid topping")
            
        ##adding the topping list to the individual pizza list
        pizza.append(toppings)

        ##adding the individual pizza info to the whole pizza list as a tuple
        pizzas.append(tuple(pizza))

        ##asking if the user wants to place more orders
        temp = input("Do you want to continue ordering? ")
        
        #if the user does not wants to continue
        if (temp.upper() == "NO" or temp.upper() == "Q"):
            continueOrder = False       #change the continue value to false and break the loop, so that the process no longer continues

        #Reset the topping and pizza value
        toppings = []
        pizza = []

##send the list to the generate list function.
generateReceipt(pizzas)