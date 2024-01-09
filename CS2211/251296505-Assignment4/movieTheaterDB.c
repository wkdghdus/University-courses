#include <stdio.h>
#include <stdbool.h>
#include <string.h>


#define MAX_MOVIE_NAME 100
#define MAX_MOVIE_GENRE 25

typedef struct movie{
    int movieCode;
    char name[MAX_MOVIE_NAME];
    char genre[MAX_MOVIE_GENRE];
    float rating;
} Movie;

bool insertMovie(Movie *index, int *movieCount, int movieCode);

bool searchMovie(Movie *index, int *movieCount, int movieCode);

bool updateMovie(Movie *index, int *movieCount, int movieCode);

void printAllMovies(Movie *index, int *movieCount);

void toString(Movie *index);

int main(void){

    Movie movies[100];
    int movieCount = 0;
    char choice = ' ';
    int movieCode;

    printf("*********************\n"
           "* 2211 Movie Cinema *\n"
           "*********************\n\n");

    while (choice != 'q'){

        Movie *movie;
        movie = &movies[0];

        printf("Enter operation code: ");
        scanf(" %c", &choice);
        
        switch (choice){

            case 'i':

                while (choice != 'n'){

                    printf("\tEnter movie code: ");
                    scanf(" %d", &movieCode);

                    if (insertMovie(movie, &movieCount, movieCode) == 1){break;}

                    printf("\t Try again? (yes: press any key/no: n): ");
                    scanf(" %c", &choice);

                }

                break;

            case 's':

                while (choice != 'n'){

                    printf("\tEnter movie code: ");
                    scanf(" %d", &movieCode);

                    if (searchMovie(movie, &movieCount, movieCode) == 1){break;}

                    printf("\t Try again? (yes: press any key/no: n): ");
                    scanf(" %c", &choice);

                }

                break;
            
            case 'u':

                while (choice != 'n'){

                    printf("\tEnter movie code: ");
                    scanf(" %d", &movieCode);

                    if (updateMovie(movie, &movieCount, movieCode) == 1){break;}

                    printf("\t Try again? (yes: press any key/no: n): ");
                    scanf(" %c", &choice);

                }

                break;

            case 'p':
                
                printAllMovies(movie, &movieCount);
                break;
            
            case 'q':

                break;

            default:

                printf("\tIllegal input!\n");


        }
        


    }

    return 0;
}


bool insertMovie(Movie *index, int *movieCount, int newMovieCode){

    //pointer arithmetic, move to the smallest available index
    for (int i = 0; i < *movieCount; i++){

        if (index->movieCode == newMovieCode){

            printf("\tMovie already exists!\n");
            return 0;

        }

        index++;

    }

    index->movieCode = newMovieCode;

    *movieCount += 1;

    char newName[MAX_MOVIE_NAME];
    char newGenre[MAX_MOVIE_GENRE];
    float newRating;

    printf("\tEnter movie name: ");
    fgetc(stdin);                  //fgetc() used to prevent the next fgets() from skipping due to \n character after scanf()
    if (fgets(newName, MAX_MOVIE_NAME, stdin)){
         size_t length = strlen(newName);
        if (length > 0 && newName[length - 1] == '\n') {
            newName[length - 1] = '\0'; // Remove the newline character
        } else {
            // If the newline character is not present, clear the input buffer
            int c;
            while ((c = getchar()) != '\n' && c != MAX_MOVIE_NAME) {
                // Consume characters until newline or end of file
            }
        }    //delete \n character from fgets()

        strcpy(index->name, newName);

    }
    else{
        printf("\tError occured! \n");
        return 0;
    }
    

    printf("\tEnter movie genre: ");
    if (fgets(newGenre, MAX_MOVIE_GENRE, stdin)){
        size_t length = strlen(newGenre);
        if (length > 0 && newName[length - 1] == '\n') {
            newGenre[length - 1] = '\0'; // Remove the newline character
        } else {
            // If the newline character is not present, clear the input buffer
            int c;
            while ((c = getchar()) != '\n' && c != MAX_MOVIE_GENRE) {
                // Consume characters until newline or end of file
            }
        }   //delete \n character from fgets()

        strcpy(index->genre, newGenre);

    }
     else{
        printf("\tError occured! \n");
        return 0;
    }
    
    

    printf("\tEnter movie rating: ");
    scanf(" %f", &newRating); 

    if (newRating < 0.0 || newRating > 10.0){
        printf("\tMovie rating must be between 0.0 and 10.0\n");
        return 0;
    }
    else{
        index->rating = newRating;
    }

    return 1;

}

bool searchMovie(Movie *index, int *movieCount, int newMovieCode){

    for (int i = 0; i < *movieCount; i++){

        if (index->movieCode == newMovieCode){

            printf("%-5s %-40s %-25s %-5s\n", "Code", "Name", "Genre", "Rating");
            toString(index);
            return 1;

        }

        index++;

    }

    printf("\tMovie not found!\n");
    return 0;

}

bool updateMovie(Movie *index, int *movieCount, int newMovieCode){

    for (int i = 0; i < *movieCount; i++){

        if (index->movieCode == newMovieCode){

            char newName[MAX_MOVIE_NAME];
            char newGenre[MAX_MOVIE_GENRE];
            float newRating;

            printf("\tEnter movie name: ");
            fgetc(stdin);                  //fgetc() used to prevent the next fgets() from skipping due to \n character after scanf()
            if (fgets(newName, MAX_MOVIE_NAME, stdin)){
                size_t length = strlen(newName);
                if (length > 0 && newName[length - 1] == '\n') {
                    newName[length - 1] = '\0'; // Remove the newline character
                } else {
                    // If the newline character is not present, clear the input buffer
                    int c;
                    while ((c = getchar()) != '\n' && c != MAX_MOVIE_NAME) {
                        // Consume characters until newline or end of file
                    }
                }    //delete \n character from fgets()

                strcpy(index->name, newName);

            }
            else{
                printf("\tError occured! \n");
                return 0;
            }
            

            printf("\tEnter movie genre: ");
            if (fgets(newGenre, MAX_MOVIE_GENRE, stdin)){
                size_t length = strlen(newGenre);
                if (length > 0 && newName[length - 1] == '\n') {
                    newGenre[length - 1] = '\0'; // Remove the newline character
                } else {
                    // If the newline character is not present, clear the input buffer
                    int c;
                    while ((c = getchar()) != '\n' && c != MAX_MOVIE_GENRE) {
                        // Consume characters until newline or end of file
                    }
                }   //delete \n character from fgets()

                strcpy(index->genre, newGenre);

            }
            else{
                printf("\tError occured! \n");
                return 0;
            }
            
            

            printf("\tEnter movie rating: ");
            scanf(" %f", &newRating); 

            if (newRating < 0.0 || newRating > 10.0){
                printf("\tMovie rating must be between 0.0 and 10.0\n");
                return 0;
            }
            else{
                index->rating = newRating;
            }

            return 1;

        }

        index++;

    }

    printf("\tMovie not found!\n");
    return 0;

}

void printAllMovies(Movie *index, int *movieCount) {
    printf("%-5s %-40s %-25s %-5s\n", "Code", "Name", "Genre", "Rating");

    for (int i = 0; i < *movieCount; i++) {
        toString(index);
        index++;
    }
}

void toString(Movie *index) {
    printf("%-5d %-40s %-25s %-5.1f\n", index->movieCode, index->name, index->genre, index->rating);
}