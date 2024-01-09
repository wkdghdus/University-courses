#include "movieTheaterDB_actor.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

//function definitions

//creating actor based on user prompts
struct Actor* createActor(){


    //prompt user for actor information
    int code;
    char name[50];
    int age;
    char imdbProfile[50];

    printf("Enter actor code: ");
    scanf(" %d", &code);

    //check condition for actor code
    if (code < 0){
        printf("Invalid actor code\n");
        return NULL;
    }

    printf("Enter actor name: ");
    scanf(" %s", &name);
    //check condition for actor name
    if (strlen(name) + 1 == 50 && name[49] != '\0'){
        printf("Invalid actor name\n");
        return NULL;
    }



    printf("Enter actor age: ");
    scanf(" %d", &age);
    //check condition for actor genre
    if (age < 0 || age > 120){
        printf("Invalid actor age\n");
        return NULL;
    }

    printf("Enter actor IMDB profile page: ");
    scanf(" %s", &imdbProfile);
    //check condition for actor rating
    if (strlen(imdbProfile) + 1 == 50 && imdbProfile[49] != '\0'){
        printf("Invalid actor rating\n");
        return NULL;
    }


    struct Actor* newactor = (struct Actor*)malloc(sizeof(struct Actor));
    newactor->code = code;
    strcpy(newactor->name, name);
    newactor->age = age;
    strcpy(newactor->imdbProfile, imdbProfile);
    newactor->next = NULL;
    
    return newactor;

}
void insertActor(struct Actor** head){

    //create new actor
    struct Actor* newActor = createActor();

    //check if actor is null
    if (newActor == NULL){
        return;
    }

    struct Actor* current = *head;
    //if head is null, set head to new actor
    if (current == NULL || current->code > newActor->code){
        *head = newActor;
        printf("new actor inserted\n");
        return;
    }
    else{

        //loop through linked list to find correct position to insert actor
        while (current->next != NULL){

            if(current->code == newActor->code){
                printf("Actor code already exists\n");
                return;
            }
            else if(current->next == NULL){
                current->next = newActor;
                printf("new actor inserted\n");

                return;
            }
            else if (current->next->code > newActor->code){
                newActor->next = current->next;
                current->next = newActor;
                printf("new actor inserted\n");

                return;
            }

            current = current->next;

        }
    }

}

void searchActor(int code, struct Actor* head){

    struct Actor* current = head;

    //loop through linked list to find actor code
    while (current != NULL){

        if (current->code == code){
            printf("Actor code: %d\n", current->code);
            printf("Actor name: %s\n", current->name);
            printf("Actor age: %d\n", current->age);
            printf("Actor IMDB profile: %s\n", current->imdbProfile);
            return;
        }

        current = current->next;

    }

    printf("Actor code not found\n");

}
void updateActor(struct Actor* head, int code){

    struct Actor* current = head;

    //loop through linked list to find actor code
    while (current != NULL){

        if (current->code == code){

            printf("Actor code: %d\n", current->code);
            printf("Actor name: %s\n", current->name);
            printf("Actor age: %d\n", current->age);
            printf("Actor IMDB profile: %s\n", current->imdbProfile);

            //prompt user for new actor information
            struct Actor* newActor = createActor();

            //check if actor is null
            if (newActor == NULL){
                return;
            }

            newActor->next = current->next;
            current = newActor;

            return;

        }

        current = current->next;

    }

            

}
void eraseActor(struct Actor** head, int code){

    struct Actor* current = *head;
    struct Actor* temp = NULL;

    //if head is null, print error message
    if (current == NULL){
        printf("No actors in database\n");
        return;
    }

    if (current->code == code){
        *head = current->next;
        free(current);
        return;
    }

    //if head is not null, traverse through list until actor code is found
    while (current != NULL){

        if (current->code == code){
            temp = current;
            current = current->next;
            free(temp);
            return;
        }

        current = current->next;

    }

    //if actor code is not found, print error message
    printf("Actor code not found\n");


}

void printActors(struct Actor* head){

    struct Actor* current = head;

    //if head is null, print error message
    if (current == NULL){
        printf("No actors in database\n");
        return;
    }

    //if head is not null, traverse through list and print actor information
    while (current != NULL){

        printf("Actor code: %d\n", current->code);
        printf("Actor name: %s\n", current->name);
        printf("Actor age: %d\n", current->age);
        printf("Actor IMDB profile: %s\n", current->imdbProfile);
        printf("\n");
        current = current->next;
        
    }

}