#include <stdio.h>

int main(void){
    int i1, i2, i3, i4;

    printf("Enter four integers: ");
    scanf("%d%d%d%d", &i1, &i2, &i3, &i4);

    //find the largest number out of four
    int largest = i1;
    if (i2 > largest){
        largest = i2;
    }
    if (i3 > largest){
        largest = i3;
    }
    if (i4 > largest){
        largest = i4;
    }
    printf("Largest: %d\n", largest);

    //find the smallest number out of four
    int smallest = i1;
    if (i2 < smallest){
        smallest = i2;
    }
    if (i3 < smallest){
        smallest = i3;
    }
    if (i4 < smallest){
        smallest = i4;
    }
    printf("Smallest: %d\n", smallest);


    //a program that prints a one-month calendar. 
    //The user specifies the number of days in the month and the day of the week on which the months begins
    int days, startDay;
    
    printf("Enter number of days in month: ");
    scanf("%d", &days);
    printf("Enter starting day of the week (1=Sun, 7=Sat): ");
    scanf("%d", &startDay);

    //print the days of the week
    for (int i = 1; i < startDay; i++){
        printf("   ");
    }

    for (int i = 1; i <= days; i++){

        printf("%-3d", i);

        if ((i + startDay - 1) % 7 == 0){
            printf("\n");
        }

    }


    return 0;
}