#prelab
#A. 2
#B. 0
#C. 7
#D. 9
#E. 4
#.F 0

#Part 1

n = int(input("How many numbers do you want to use today?"))

firstValue = int(input("Enter the first. number: "))

largest = firstValue
smallest = firstValue
total = firstValue

counter = 0
while counter < (n-1):
    current = int(input("Enter the next number: "))
    total += current
    counter += 1

    if current < smallest:
        smallest = current
    elif current > largest:
        largest = current

print ("the average of the values is: ", total/n)
print ("the smallest of the value is {}".format(smallest))
print ("the largest of the value is {}".format(largest))
print ("the range of the value is {}".format(largest - smallest))


#part 2
accountTotal = 50
while accountTotal > 20:
    print (accountTotal)
    accountTotal -= 1

print ('Your account has reached $20')