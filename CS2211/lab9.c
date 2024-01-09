#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 1000   // Maximum length of each word

int main() {
    char currentWord[MAX_LENGTH];       // Temporary storage for each word entered
    char largestWord[MAX_LENGTH] = "a";
    char smallestWord[MAX_LENGTH] = "z";

    // Accept words from the user until an empty word is entered
    while (1) {

        printf("Enter word: ");
        fgets(currentWord, MAX_LENGTH, stdin);
        
        if (currentWord[0] == '\n') {
            break;  // Exit if no word is entered
        }

        // Update the number of words entered
        if (strcmp(currentWord, smallestWord) < 0) {
            strcpy(smallestWord, currentWord);
        }
        if (strcmp(currentWord, largestWord) > 0) {
            strcpy(largestWord, currentWord);
        }

    }

    // Display the results
    printf("\nFirst: %s", smallestWord);
    printf("Last: %s", largestWord);
    

    return 0;
}
