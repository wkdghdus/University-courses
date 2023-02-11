#### Date: October 5th, 2022
#### By Hoyeon Luke Jang
#### A program which calculates user's inflation rate and output the result and type of interest

### Getting inputs from users
## current year
currentYear = int(input("Please enter the year that you want to calculate the personal interest rate for: "))

## number of expenditure categories
expCatNum = int(input("Please enter the number of expenditure categories: "))

##Declaring variable before asking for the input and calculating
#total expenses of the previous year
ttlPrevExp = 0
#total expenses of the current year
ttlCurrExp = 0

## get input for previous expense and current expense
for i in range(0, expCatNum):
    ##Expenses for previous year
    expPrev = float(input("Please enter expenses for previous year: "))
    ##Expenses for current year
    expCurr = float(input("Please enter expenses for year of interest: "))

    ##calculating total expenses
    # total expenses of the previous year
    ttlPrevExp += expPrev
    #total expenses of the current year
    ttlCurrExp += expCurr

##Calculations
#Calculating inflation rate beased on the given formula
infRate = ((ttlCurrExp - ttlPrevExp) / ttlCurrExp) * 100
# determine the type of inflation rate
if infRate >= 10:
    infType = "Hyper"
elif infRate > 5:
    infType = "High"
elif infRate >= 3:
    infType = "Moderate"
elif infRate == 5:
    infType = "Not defined"     #The classification in the assignment does not specify the inflation type when the rate is 5%
else:
    infType = "Low"

## Output results
#Printing inflation rate
print("Personal inflation rate for %i is %.1f%%" % (currentYear, infRate) )
#Printing inflation type
print("Type of Inflation: %s" % (infType))