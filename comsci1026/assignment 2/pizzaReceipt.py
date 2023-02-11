# Name: pizzaReceipt.py
# By Hoyeon Luke Jang
# Date: October 26th, 2022
#Description: A program with a function which generates a receipt once given a list of pizza orders in tuples

# Name: generateReceipt
# function which creates a receipt
# parameter: list with tuples of order information for each pizzas
def generateReceipt(pizzaOrder):

    #before entering the function, check if the parameter is an empty list.
    if pizzaOrder == []:
        print("You did not order anything")
        return      #exit function

    ## Declare and initializing the variables with sentinels value
    ttlPrice = 0.0          #Total Price
    pzzBasePrice = 0.0      #Base price of the pizza
    tax = 0.0               #Tax
    pzzCount = 1            #Number of pizzas
    size = ""               #Size of the pizza


    ## Declaring and initializing constants
    # Base Price
    XL_BASE_PRICE = 13.99   #Extra Large base price
    L_BASE_PRICE = 11.99    #Large base price
    M_BASE_PRICE = 9.99     #Medium base price
    S_BASE_PRICE = 7.99     #Small base price

    # Extra Topping price
    XL_TOPPING_PRICE = 1.25 #Extra Large topping price
    L_TOPPING_PRICE = 1.00  #Large topping price
    M_TOPPING_PRICE = 0.75  #Medium topping price
    S_TOPPING_PRICE = 0.50  #Small topping price

    # Tax
    TAX_RATE = 0.13


    ## Printing receipt
    print("Your order:")

    #looping through the list of pizza order
    for pizza in pizzaOrder:

        ##assigning variables its value
        size = pizza[0]     #size of the pizza

        #base price and extra topping price of the pizza depending on its size
        if size == "S":                 #if the size is small
            pzzBasePrice = S_BASE_PRICE
        elif size == "M":               #if the size is medium
            pzzBasePrice = M_BASE_PRICE
        elif size == "L":               #if the size is large
            pzzBasePrice = L_BASE_PRICE
        elif size == "XL":              #if the size is extra large
            pzzBasePrice = XL_BASE_PRICE
    
        # update total price (add the base price)
        # not adding the topping price as the value may be negative
        ttlPrice += pzzBasePrice 

        ## printing the values
        #pizza number, size, and the base price
        print("Pizza %d: %-2s %13.2f" % (pzzCount, size, pzzBasePrice))
        
        #listing the toppings added
        for topping in pizza[1]:
            print(" - " + topping)
        
        #extra topping price if there is any
        for i in range (len(pizza[1])-3):
            if size == "S":                 #if the size is small
                print("Extra Topping %-4s %6.2f" % ('(' + size + ')', S_TOPPING_PRICE))
                ttlPrice += S_TOPPING_PRICE
            elif size == "M":               #if the size is medium
                print("Extra Topping %-4s %6.2f" % ('(' + size + ')', M_TOPPING_PRICE))
                ttlPrice += M_TOPPING_PRICE
            elif size == "L":               #if the size is large
                print("Extra Topping %-4s %6.2f" % ('(' + size + ')', L_TOPPING_PRICE))  
                ttlPrice += L_TOPPING_PRICE
            elif size == "XL":              #if the size is extra large
                print("Extra Topping %-4s %6.2f" % ('(' + size + ')', XL_TOPPING_PRICE))
                ttlPrice += XL_TOPPING_PRICE


        # updating pizza count
        pzzCount += 1

    
    ##updating tax and the total price after looping through all the orders
    tax = ttlPrice * TAX_RATE
    ttlPrice += tax

    ## output tax and the total price
    # tax
    print("Tax: %20.2f" % (tax))
    # total price
    print("Total: %18.2f" % (ttlPrice))