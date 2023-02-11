# exercise 1
def exercise1 ():
    list = []
    unique10 = False

    while not unique10:
        num = float(input("Enter a number: "))

        if num not in list:
            list.append(num)
        
        if len(list) == 10:
            unique10 = True

    print(list)

# exercise 2
def exercise2 (list):

    count = 0
    for word in list:

        if len(word) >= 2:
            if word[0] == word[-1]:
                count += 1
    
    return count

#exercise 3
def zFirst(words):
    #We will need two lists
    zresult = []
    result = []

    for word in words:
        if word.lower()[0] == 'z':
            #if it does, add it to the first list
            zresult.append(word)
        else:
            #does not begin with a 'z' or 'Z'
            result.append(word)
    
    zresult.sort()
    result.sort()
    
    return zresult + result

#exercise 4
def exercise4 ():
    values = [1,2,3,4,5]
    newValues = list(values)

    for i in range(len(values)):
        newValues[i] += 1
        print("Old Value at index {} is: {}".format(i, values[i]))
        print("New Value at index {} is: {} \n".format(i, newValues[i]))

def main():
    exercise1()

    print("")

    list = ['bgh', 'wer', 'yuy', '1661']
    print(exercise2(list), "\n")

    words =  ['asparagus', 'zoo', 'a', 'absorb', 'sword', 'am', 'ants', 'as', 'zebra', 'at', 'baseball', 'because', 'zealot', 'bored', 'do', 'get', 'good', 'hello', 'hi', 'how', 'nice', 'pool', 'seven', "that's", 'silver', 'so', 'tall', 'want', 'we', 'xylophone', 'you', 'you']
    print(zFirst(words))

    print("")

    exercise4()

main()


