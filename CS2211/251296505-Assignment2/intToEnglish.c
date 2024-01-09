/**
 * Assignment 2
 * CS 2211
 * intToEnglish.c
 * A program that converts any integer from 1-999 into the English word (in lower case)
 * 
 * Author: Hoyeon Luke Jang

*/

#include <stdio.h>

int main(void) {
    
    //variables
    int input;     //variable for user input 
    int hundred;   //variable for hundredth digit
    int ten;       //variable for tenth digit
    int one;       //variable for first digit

    //loop to continue the process until user terminates
    while(1){

        //get input
        printf("Please enter a value (1-999, 0 to quit): ");
        scanf("%d", &input);

        //check if user wants to terminate
        if (input == 0) {

            printf("thank you for using the program\n"); 

            return 0;

        }

        //print the output
        printf("\nYou entered the number ");

        ////check how many digits the input has
        //if the input has 3 digits, add hundredth digit to the output
        if (input >= 100){

            switch(input / 100){

                case 1:
                    printf("one hundred");
                    break;
                case 2:
                    printf("two hundred");
                    break;
                case 3:
                    printf("three hundred");
                    break;
                case 4:
                    printf("four hundred");
                    break;
                case 5:
                    printf("five hundred");
                    break;
                case 6:
                    printf("six hundred");
                    break;
                case 7:
                    printf("seven hundred");
                    break;
                case 8:
                    printf("eight hundred");
                    break;
                case 9:
                    printf("nine hundred");
                    break;

            }

        }

        //if the input is not a multiple of 100 and has 3 digits, add "and" to the output
        if ((input % 100) != 0 && input >= 100){

            printf(" and ");

        }

        //if the input has 2 or more digits, add tenth digit to the output
        if (input >=10){

            //extracting the tenth digit
            switch((input % 100) / 10){
                
                //if the tenth digit is 1, add the corresponding number to the output
                case 1:

                    switch (input % 10){

                        case 0:
                            printf("ten");
                            break;
                        case 1:
                            printf("eleven");
                            break;
                        case 2:
                            printf("twelve");
                            break;
                        case 3:
                            printf("thirteen");
                            break;
                        case 4:
                            printf("fourteen");
                            break;
                        case 5:
                            printf("fifteen");
                            break;
                        case 6:
                            printf("sixteen");
                            break;
                        case 7:
                            printf("seventeen");
                            break;
                        case 8:
                            printf("eighteen");
                            break;
                        case 9:
                            printf("nineteen");
                            break;
                        default:
                            break;
                    }

                    break;

                case 2:
                    printf("twenty");
                    break;
                case 3:
                    printf("thirty");
                    break;
                case 4:
                    printf("forty");
                    break;
                case 5:
                    printf("fifty");
                    break;
                case 6:
                    printf("sixty");
                    break;
                case 7:
                    printf("seventy");
                    break;
                case 8:
                    printf("eighty");
                    break;
                case 9:
                    printf("ninety");
                    break;
                default:
                    break;

            }

        }

        //if the input has a first digit and the tenth digit is not 1, add a dash to the output
        if (((input%100)/10) > 1 && input%10 != 0){

            printf("-");

        }

        //printing first digit if the input is not between 10 and 19
        if ((input % 100) / 10 != 1){

            switch (input % 10){

                case 1:
                    printf("one");
                    break;
                case 2:
                    printf("two");
                    break;
                case 3:
                    printf("three");
                    break;
                case 4:
                    printf("four");
                    break;
                case 5:
                    printf("five");
                    break;
                case 6:
                    printf("six");
                    break;
                case 7:
                    printf("seven");
                    break;
                case 8:
                    printf("eight");
                    break;
                case 9:
                    printf("nine");
                    break;
                default:
                    break;

            }

        }

        //divider
        printf("\n\n");


    }

}