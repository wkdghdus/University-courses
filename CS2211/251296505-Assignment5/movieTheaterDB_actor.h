#ifndef MOVIETHEATER_ACTOR_H
#define MOVIETHEATER_ACTOR_H

struct Actor {
    int code;
    char name[50];
    int age;
    char imdbProfile[50];
    struct Actor* next;
};

struct Actor* createActor();
void insertActor(struct Actor** head);
void searchActor(int code, struct Actor* head);
void updateActor(struct Actor* head, int code);
void eraseActor(struct Actor** head, int code);
void printActors(struct Actor* head);

#endif // ACTORS_H