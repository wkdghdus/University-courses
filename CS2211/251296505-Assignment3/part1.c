/**
 * Author: Hoyeon Luke Jang
 * Date: Oct 24, 2023
 * Compsci2011 - Assignment 3 part 1
 * 
 * a program to accept integers separated by spaces place the integers into an array
 * and work on the integers found in the array
*/


#include <stdio.h>
#include <limits.h>

//part 1: show array elements
void part1(int array[], int arraySize){

    printf("Your array is: ");
    for (int i = 0; i < arraySize; i++){
    
        printf("[%d] = %d, ", i, array[i]);
    
    }

}


//part 2: show array elements in reverse order
void part2(int array[], int arraySize){

    printf("\n \n Your array in reverse is: ");
    //loop from the last index to the first index
    for (int i = arraySize - 1; i >= 0; i--){
    
        printf("[%d] = %d, ", i, array[i]);
    
    }

}

//part 3: show the even element(s) in the array
void part3(int array[], int arraySize){

    printf("\n \n The even elements in the array is: ");
    for (int i = 0; i < arraySize; i++){

        //check if the element is even
        if (array[i] % 2 == 0){
    
            printf("[%d] = %d, ", i, array[i]);
    
        }

    }

}


//part 4: show the sum of all array elements
void part4(int array[], int arraySize){

    int sum = 0; //declare sum variable
    printf("\n \n The sum of all values in your array is: ");
    for (int i = 0; i < arraySize; i++){

        sum += array[i];

    }

    printf("%d", sum);  //print sum

}

//part 5: show array in sorted order
void part5(int array[], int arraySize){

    printf("\n \n Your array in sorted order is: ");

    //duplicate array so that the initial array is not affected
    int tempArray[arraySize];
    for (int i = 0; i < arraySize; i++){

        tempArray[i] = array[i];

    }

    //find minimum and print, then modify the value so that it is not considered again
    for (int i = 0; i < arraySize; i++){

        //initialize min and minIndex
        int min = tempArray[0];
        int minIndex = 0;

        //find minimum
        for (int j = 0; j < arraySize; j++){

            if (tempArray[j] < min){

                min = tempArray[j];
                minIndex = j;

            }

        }

        printf("[%d] = %d, ", minIndex, min);
        //modify the value so that it is not considered again
        tempArray[minIndex] = INT_MAX;      //maximum value of int (constant in limits.h)

    }

}

//part 6: swap the first and last elements of the array
void part6(int array[], int arraySize){

    printf("\n \n Your array with the first and last elements swapped is: [%d] = %d, " , arraySize - 1, array[arraySize - 1]); //print the last element of the array
    //print the elements in between the first and last index
    for (int i = 1; i < arraySize - 1; i++){

        printf("[%d] = %d, ", i, array[i]);

    }

    //print the first element of the array
    printf("[0] = %d, ", array[0]);
    
}



int main(void){

    int arraySize = 0;

    //array size must be between 5 to 12. 
    //repeat scanning until user gives valid input.
    while (arraySize < 5 || arraySize > 12){

        //parse array size
        printf("Please enter the number of integers to process: ");
        scanf("%d", &arraySize);

    }
    

    //declare array
    int array[arraySize];

    //show array info
    printf("\t There is enough room in your array for %d integers (%lu bytes) \n \n", arraySize, sizeof(array));

    //parse array elements
    printf("Please enter your integers separated by spaces: ");

    for (int i = 0; i < arraySize; i++){

        scanf("%d", &array[i]);
    
    }

    //call the corresponding function for each parts
    part1(array, arraySize);
    part2(array, arraySize);
    part3(array, arraySize);
    part4(array, arraySize);
    part5(array, arraySize);
    part6(array, arraySize);

    //end main
    return 0;

}   