// movieTheaterdb.c
#include "movieTheaterDB_movie.h"
#include "movieTheaterDB_actor.h"
#include "movieTheaterDB.h"
#include <string.h>
#include <stdio.h>



int main() {
    
    char option;
    struct Movie* movieHead = NULL;
    struct Actor* actorHead = NULL;

    for(;;){

        printf("\n\nMovie Theater Database Program\n\n");
        printf(PROGRAM_MENU);
        
        printf("Please select an option: ");
        scanf(" %c", &option);

        switch(option){
            case 'h':
                printf(PROGRAM_SPECIFICATION);
                break;
            case 'q':
                printf("Exiting program...\n");
                return 0;
            case 'm':
                movieHead = manageMovieOption(movieHead);
                break;
            case 'a':
                actorHead = manageActorOption(actorHead);
                break;
            default:
                printf("Invalid option\n");
                break;
        }


    }


}

struct Movie* manageMovieOption(struct Movie* movieHead){

    printf("\nMovie Management Menu\n");
    printf(MOVIE_MENU);

    printf("Please select an option: ");
    char option;
    int code;
    scanf(" %c", &option);
    printf("\n");

    switch(option){
        case 'i':
            insertMovie(&movieHead);   
                     
            break;
        case 's':
            printf("Enter movie code: ");
            scanf(" %d", &code);

            searchMovie(code, movieHead);
            break;
        case 'u':
            printf("Enter movie code: ");
            scanf(" %d", &code);

            updateMovie(movieHead, code);
            break;
        case 'e':
            printf("Enter movie code: ");
            scanf(" %d", &code);

            eraseMovie(&movieHead, code);
            break;
        case 'p':
            printMovies(movieHead);
            break;
        default:
            printf("Invalid option\n");
            break;
    }

    return movieHead;

}

struct Actor* manageActorOption(struct Actor* actorHead){

    printf("\nActor Management Menu\n");
    printf(ACTOR_MENU);

    char option;
    int code;

    printf("Please select an option: ");
    scanf(" %c", &option);
    printf("\n");

    switch(option){
        case 'i':
            insertActor(&actorHead);
            break;
        case 's':
            printf("Enter actor code: ");
            scanf(" %d", &code);

            searchActor(code, actorHead);
            break;
        case 'u':
            printf("Enter actor code: ");
            scanf(" %d", &code);

            updateActor(actorHead, code);
            break;
        case 'e':
            printf("Enter actor code: ");
            scanf(" %d", &code);

            eraseActor(&actorHead, code);
            break;
        case 'p':
            printActors(actorHead);
            break;
        default:
            printf("Invalid option\n");
            break;
    }

    return actorHead;

}