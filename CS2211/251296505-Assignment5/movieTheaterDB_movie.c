#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "movieTheaterDB_movie.h"

//function definitions

//creating movie based on user prompts
struct Movie* createMovie(){
    
    //prompt user for movie information
    int code;
    char name[100];
    char genre[25];
    float rating;

    printf("Enter movie code: ");
    scanf(" %d", &code);

    //check condition for movie code
    if (code < 0){
        printf("Invalid movie code\n");
        return NULL;
    }

    printf("Enter movie name: ");
    scanf(" %s", &name);
    //check condition for movie name
    if (strlen(name) + 1 == 100 && name[99] != '\0'){
        printf("Invalid movie name\n");
        return NULL;
    }
    


    printf("Enter movie genre: ");
    scanf(" %s", &genre);
    //check condition for movie genre
    if (strlen(genre) + 1 == 25 && genre[24] != '\0'){
        printf("Invalid movie genre\n");
        return NULL;
    }

    printf("Enter movie rating: ");
    scanf(" %f", &rating);
    //check condition for movie rating
    if (rating <= 0 || rating >= 10){
        printf("Invalid movie rating\n");
        return NULL;
    }


    struct Movie* newMovie = (struct Movie*)malloc(sizeof(struct Movie));
    newMovie->code = code;
    strcpy(newMovie->name, name);
    strcpy(newMovie->genre, genre);
    newMovie->rating = rating;
    newMovie->next = NULL;

    return newMovie;

}

//inserting movie into linked list
void insertMovie(struct Movie** head){
    
    //create new movie
    struct Movie* newMovie = createMovie();

    if (newMovie == NULL){
        return;
    }

    //if head is null, set head to new movie
    struct Movie* current = *head;
    if (current == NULL || current->code > newMovie->code){
        printf("New movie appended\n");
        *head = newMovie;
    } 
    //if head is not null, traverse to end of list and insert new movie
    else{
        while (current != NULL){

            //if movie code already exists, print error message and return
            if(current->code == newMovie->code){
                printf("Movie code already exists\n");
                return;
            }
            //if movie code belongs in the end of the list, insert it
            else if (current->next == NULL){
                current->next = newMovie;
                printf("New movie appended\n");

                return;
            }
            //if movie code belongs in the middle of the list, insert it
            else if (current->next->code > newMovie->code){
                newMovie->next = current->next;
                current->next = newMovie;
                printf("New movie appended\n");

                return;
            }

            current = current->next;

        }
    }
}

//searching for movie based on movie code
void searchMovie(int code, struct Movie* head){
    
    struct Movie* current = head;

    //traverse through list until movie code is found
    while (current != NULL){

        if (current->code == code){
            printf("Movie code: %d\n", current->code);
            printf("Movie name: %s\n", current->name);
            printf("Movie genre: %s\n", current->genre);
            printf("Movie rating: %.1f\n", current->rating);
            return;
        }

        current = current->next;

    }

    //if movie code is not found, print error message
    printf("Movie code not found\n");

}

//updating movie based on movie code
void updateMovie(struct Movie* head, int code){
    
    struct Movie* current = head;

    //traverse through list until movie code is found
    while (current != NULL){

        if (current->code == code){
            printf("Movie code: %d\n", current->code);
            printf("Movie name: %s\n", current->name);
            printf("Movie genre: %s\n", current->genre);
            printf("Movie rating: %.1f\n\n", current->rating);

            //prompt user for new movie information
            struct Movie* newMovie = createMovie();

            if (newMovie == NULL){
                return;
            }

            newMovie->next = current->next;
            current = newMovie;

            return;
        }

        current = current->next;

    }

    //if movie code is not found, print error message
    printf("Movie code not found\n");
    return;

}

void eraseMovie(struct Movie** head, int code){
    
    struct Movie* current = *head;
    struct Movie* temp = NULL;

    //if head is null, print error message
    if (current == NULL){
        printf("No movies in database\n");
        return;
    }

    if (current->code == code){
        *head = current->next;
        free(current);
        return;
    }

    //if head is not null, traverse through list until movie code is found
    while (current != NULL){

        if (current->code == code){
            temp = current;
            current = current->next;
            
            free(temp);
            return;
        }

        current = current->next;

    }

    //if movie code is not found, print error message
    printf("Movie code not found\n");

}

//printing all movies in linked list
void printMovies(struct Movie* head){
    
    struct Movie* current = head;

    //traverse through list and print each movie
    if (current == NULL){
        printf("No movies in database\n");
    }

    while (current != NULL){

        printf("Movie code: %d\n", current->code);
        printf("Movie name: %s\n", current->name);
        printf("Movie genre: %s\n", current->genre);
        printf("Movie rating: %.1f\n\n", current->rating);
        current = current->next;
        
    }

}


