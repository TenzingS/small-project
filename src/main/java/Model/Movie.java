package Model;

import java.util.Objects;

public class Movie {

    //An id for this movie which will be automatically generated by the database.
    public int movie_id;

    public int rating;

    //The text for this movie. Must not be blank.
    public String movie_name;

    public String genre;

    public int posted_by;
    //A default no-args constructor, as well as correctly formatted getters and setters, are needed for
    //     * Jackson Object mapper to work.
    public Movie(){
    }

    //When posting a new movie, the id can be generated by the database. In that case, a constructor without
    //     * movie_id is needed.
    public Movie(String movie_name, String genre, int rating, int posted_by){
        this.movie_name = movie_name;
        this.genre = genre;
        this.rating = rating;
        this.posted_by = posted_by;
    }

    public Movie(int movie_id, String movie_name, String genre, int rating, int posted_by) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.genre = genre;
        this.rating = rating;
        this.posted_by = posted_by;
    }

    //Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
    //     * @return movie_id
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getPosted_by() {
        return posted_by;
    }
    public void setPosted_by(int posted_by) {
        this.posted_by = posted_by;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movie_id == movie.movie_id && Objects.equals(movie_name, movie.movie_name) && Objects.equals(genre, movie.genre) && Objects.equals(rating, movie.rating) && posted_by == movie.posted_by;
    }
    /**
     * A toString method in the event that you want to test your methods using System.out.println.
     * This was auto-generated by the IDE (alt+insert).
     * @return a String representation of this movie.
     */
    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", genre=" + genre + '\'' +
                ", rating=" + rating + '\'' +
                ", posted_by=" + posted_by +
                '}';
    }

}
