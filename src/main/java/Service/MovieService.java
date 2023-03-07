package Service;
import DAO.MovieDAO;
import Model.Movie;

import java.util.List;
public class MovieService {
    private MovieDAO movieDAO;

    public MovieService(){
        movieDAO = new MovieDAO();
    }

    public MovieService(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }

    public Movie createMovie(String movie_name, String genre, int rating) {

        if((movie_name.length() > 0 && movie_name.length() < 255) && (rating > 0 && rating <=5)){
            return movieDAO.insertMovie(movie);
        }
        return null;
    }


    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public List<Movie> getMovieByGenre(String genre) {
        return movieDAO.getMovieByGenre(genre);
    }

    public List<Movie> getMovieByRating(int rating) {
        return movieDAO.getMovieByRating(rating);
    }
}
