#ifndef MOVIETHEATERDB_MOVIE_H
#define MOVIETHEATERDB_MOVIE_H

// struct to hold movie information
struct Movie {
    int code;
    char name[100];
    char genre[25];
    float rating;
    struct Movie* next;
};

struct Movie* createMovie();
void insertMovie(struct Movie** head);
void searchMovie(int code, struct Movie* head);
void updateMovie(struct Movie* head, int code);
void eraseMovie(struct Movie** head, int code);
void printMovies(struct Movie* head);

// Function to create a new movie

#endif // MOVIETHEATERDB_MOVIE_H
