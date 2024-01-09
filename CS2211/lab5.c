#include <stdio.h>
#include <math.h>

//Write a program that asks the user to enter a value for x and then displays the value of the following polynomial (watch out for integer overflow)

int first(void){

    int x, result;

    printf("Enter a value for x: ");
    scanf("%d", &x);

    result = (3*pow(x,5)) + (2*pow(x,4)) - (5* pow(x,3)) - pow(x,2) + (7 * x) - 6;

    printf("Result: %d\n", result);

    return 0;

}

//Write a program that asks the user to enter two fractions and add them together.
int second(void){

    int num1, denom1, num2, denom2, resultNum, resultDenom;

    printf("Enter two fractions separated by a plus sign: ");
    scanf("%d/%d+%d/%d", &num1, &denom1, &num2, &denom2);

    resultNum = (num1 * denom2) + (num2 * denom1);
    resultDenom = denom1 * denom2;

    //make the fraction in lowest terms
    int gcd;

    for (int i = 1; i <= resultNum && i <= resultDenom; i++){
        if (resultNum % i == 0 && resultDenom % i == 0){
            gcd = i;
        }
    }

    printf("%d\n", gcd);

    printf("The sum is %d/%d\n", resultNum/gcd, resultDenom/gcd);

    return 0;


}

//Write a program that asks the user to enter a three-digit number, then prints the number with its digits reversed.
int third(void){

    int num, first, second, third, result;

    printf("Enter a three-digit number: ");
    scanf("%d", &num);

    first = num / 100;
    second = (num / 10) % 10;
    third = num % 10;

    result = (third * 100) + (second * 10) + first;

    printf("The reversal is: %d\n", result);

    return 0;


}

int main(void){

    first();
    second();
    third();

    return 0;
    
}