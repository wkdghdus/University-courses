



#part 1
age = int(input("Enter your age: "))
if (9 <= age): 
    height = float(input("Enter your height in CM: "))
    if (height > 130):
        print("You may go on this ride!")
    else:
        print("You are too short for this ride")
else:
    print("You are too young for this ride")

##part 2
#wrong code

IDEAL_CREDIT_SCORE = 720

userScore = int(input("Please enter your credit score: "))
housePrice = int(input("Please enter the price of the house: "))

if userScore => IDEAL_CREDIT_SCORE:
    downPayment q = 0.1 * housePrice
else if userScore < IDEAL_CREDIT_SCORE and userScore > "600":
    downPayment = 0.2 * housePrice
else:
downPayment = 0.3 * housePrice

print("Your house payment is: {}".format(downPayment))


#corrected
IDEAL_CREDIT_SCORE = 720 

userScore = int(input("Please enter your credit score: "))
housePrice = int(input("Please enter the price of the house: "))

if userScore >= IDEAL_CREDIT_SCORE: #the expression greater or less was wrong
    downPayment = 0.1 * housePrice
elif userScore < IDEAL_CREDIT_SCORE and userScore > 600: #else if expression is written elif in python # the number must be in int value not string
    downPayment = 0.2 * housePrice
else:
    downPayment = 0.3 * housePrice #fixed indentation

print("Your down payment is: {}".format(downPayment))

##three test cases
#1. 1000, 100
#2. 601, 100
#3. 200, 100