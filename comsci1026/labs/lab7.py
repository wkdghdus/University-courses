#excercise one

values = [1,2,3,4,5, "hello", 6,7,8,9,"10"]

for cur in values:
    print("The value is :", values[cur])
    if type(values[cur]) == str:
        raise ValueError("This is a string!")



try:
    
except ValueError:
    print("Value Error")
except ValueError as exception:
    print("Error: ", str(exception))


#Excercise 3
filename = input("Enter filename: ")
try:
    infile = open(filename, "r")
    line = infile.readline()
    value = int(line)
except IOError:
    print ("Such a file does not exist")
except ValueError:
    print ("The line cannot be converted to an integer")  