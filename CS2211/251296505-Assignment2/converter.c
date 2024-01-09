/**
 * Assignment 2
 * CS 2211
 * converter.c
 * A converter program that helps users to convert between different units of its choice.
 * 
 * Author: Hoyeon Luke Jang

*/

#include <stdio.h>

int main(void){

    //declare variable
    int choice;             //variable for user's choice
    float input, output;    //variable for input (original) unit and output (converted) unit

    //loop infinitely until user enters 5
    while(1){

        //print menu
        printf("------------------------------------------------------------------------------\n");
        printf("1 for conversion between Kilograms and Pounds (1 kilogram == 2.20462 pounds)\n");
        printf("2 for conversion between Hectares and Acres (1 hectare == 2.47105 acres) \n");
        printf("3 for conversion between Litres and Gallons (1 litre == 0.264172 gallons) \n");
        printf("4 for conversion between Kilometer and Mile (1 kilometer == 0.621371 mile) \n");
        printf("5 for quit\n");

        //get input
        printf("Enter your choice: ");
        scanf("%d", &choice);

        //check choice and perform corresponding action
        switch (choice){

            //variable for unit choice that users will make
            char unit;

            case 1:
                /* conversion between Kg and Lb */
                printf("\nEnter the unit of the value that'll be converted (K for Kilograms to Pounds, P for Pounds to Kilogram): ");
                scanf(" %c", &unit); //space before %c to ignore any leading white spaces

                //conversion depending on the unit
                if (unit == 'K' || unit == 'k'){
                    /* Kilogram to Pounds */

                    //get input
                    printf("\nEnter the value to be converted in Kg: ");
                    scanf("%f", &input);

                    //convert
                    output = input * 2.20462;
                    printf("\nYour conversion from %f Kg to Pounds is %f Lb\n", input, output);

                }
                else if (unit == 'P' || unit == 'p'){
                    /* Pounds to Kilograms */

                    //get input
                    printf("\nEnter the value to be converted in Lb: ");
                    scanf("%f", &input);

                    //convert
                    output = input / 2.20462;
                    printf("\nYour conversion from %f Lb to Kg is %f Kg\n", input, output);

                }
                else{
                    printf("\nInvalid input\n");
                }
                break;

            case 2:

                /* conversion between Hectares and Acres */
                printf("\nEnter the unit of the value that'll be converted (H for Hectares to Acres, A for Acres to Hectares): ");
                scanf(" %c", &unit); //space before %c to ignore any leading white spaces

                //conversion depending on the unit
                if (unit == 'H' || unit == 'h'){
                    /* Hectares to Acres*/

                    //get input
                    printf("\nEnter the value to be converted in Hectares: ");
                    scanf("%f", &input);

                    //convert
                    output = input * 2.47105;
                    printf("\nYour conversion from %f Hectares to Acres is %f Acres\n", input, output);

                }
                else if (unit == 'A' || unit == 'a'){
                    /*Acres to Hectares*/

                    //get input
                    printf("\nEnter the value to be converted in Acres: ");
                    scanf("%f", &input);

                    //convert
                    output = input / 2.47105;
                    printf("\nYour conversion from %f Acres to Hectares is %f Hectares\n", input, output);

                }
                else{
                    printf("\nInvalid input\n");
                }

                break;
            case 3:

                /* conversion between Litres and Gallons */

                printf("\nEnter the unit of the value that'll be converted (L for Litres to Gallons, G for Gallons to Litres): ");
                scanf(" %c", &unit); //space before %c to ignore any leading white spaces
                
                //conversion depending on the unit
                if (unit == 'L' || unit == 'l'){
                    /* Litres to Gallons */

                    //get input
                    printf("\nEnter the value to be converted in Litres: ");
                    scanf("%f", &input);

                    //convert
                    output = input * 0.264172;
                    printf("\nYour conversion from %f Litres to Gallons is %f Gallons\n", input, output);

                }
                else if (unit == 'G' || unit == 'g'){
                    /* Gallons to Litres */

                    //get input
                    printf("\nEnter the value to be converted in Gallons: ");
                    scanf("%f", &input);

                    //convert
                    output = input / 0.264172;
                    printf("\nYour conversion from %f Gallons to Litres is %f Litres\n", input, output);

                }
                else{
                    printf("\nInvalid input\n");
                }

                break;

            case 4:
                /* Conversion between kilometer and mile */
                printf("\nEnter the unit of the value that'll be converted (K for Kilometer to Mile, M for Mile to Kilometer): ");
                scanf(" %c", &unit);    //space before %c to ignore any leading white spaces

                //conversion depending on the unit
                if (unit == 'K' || unit == 'k'){

                    /* Kilometer to Mile */

                    //get input
                    printf("\nEnter the value to be converted in Kilometer: ");
                    scanf("%f", &input);

                    //convert
                    output = input * 0.621371;
                    printf("\nYour conversion from %f Kilometer to Mile is %f Mile\n", input, output);

                }
                else if (unit == 'M' || unit == 'm'){
                    /* Mile to Kilometer */

                    //get input
                    printf("\nEnter the value to be converted in Mile: ");
                    scanf("%f", &input);

                    //convert
                    output = input / 0.621371;
                    printf("\nYour conversion from %f Mile to Kilometer is %f Kilometer\n", input, output);

                }
                else{
                    printf("\nInvalid input\n");
                }

                break;
            case 5:
                /* Quit */

                printf("\nThank you for using the converter\n");

                //end program
                return 0;

                break;

            default:
                break;
        
        }

    }
    


}