# Write a computer program (in Java, Matlab or Python) which takes as input the matrix
# representing a relation on a finite set, and gives as output the matrix representing the
# symmetric closure of this relation. Write the output of your program corresponding to the input

def toString(input):
    output = ""
    for i in range(len(input)):
        for j in range(len(input)):
            output += str(input[i][j]) + " "
        output += "\n"
    return output

def symmetric_closure(input):
    output = input
    #loop through input matrix and adjust the output matrix accordingly so that output matrix is the symmetric closure of the input matrix
    for i in range(len(input)):
        for j in range(len(input)):

            #if the input matrix has a 1 in the i,j position and a 0 in the j,i position
            if input[i][j] == 1 and input[j][i] == 0:
                #set the output matrix to have a 1 in the j,i position
                output[j][i] = 1
            #if the input matrix has a 0 in the i,j position and a 1 in the j,i position
            if input[i][j] == 0 and input[j][i] == 1:
                #set the output matrix to have a 1 in the i,j position
                output[i][j] = 1
            

    return output

def main():
    input = [[0,1,0,1,1],
             [1,1,0,0,0],
             [0,0,0,1,0],
             [0,1,1,0,1],
             [0,0,0,0,0]]
    print("Input: \n" + toString(input))
    print("Output: \n" + toString(symmetric_closure(input)))

main()