//used chat gpt for this simple prompt
#define PROGRAM_SPECIFICATION "This program manages a database of movies and actors.\n It demonstrates basic functionalities like adding movies and actors,\n displaying their details, and freeing allocated memory.\n\n"
#define PROGRAM_MENU "h. print help\nq. quit\nm. manage movies\na. manage actors\n\n"
#define MOVIE_MENU "i. insert movie\ns. search movie\nu. update movie\ne. erase movie\np. print movies\n\n"
#define ACTOR_MENU "i. insert actor\ns. search actor\nu. update actor\ne. erase actor\np. print actors\n\n"

#include "movieTheaterDB_movie.h"
#include "movieTheaterDB_actor.h"

struct Movie* manageMovieOption();
struct Actor* manageActorOption();
