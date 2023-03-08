package DAO;

import Model.Movie;
import Util.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public List<Movie> getAllMovies() {
        Connection connection = ConnectionSingleton.getConnection();
        List<Movie> allMovies = new ArrayList<>();

        try{
            String sql = "SELECT * FROM movie";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Movie movie = new Movie(rs.getInt("movie_id"), rs.getString("movie_name"), rs.getString("genre"), rs.getInt("rating"));
                allMovies.add(movie);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return allMovies;
    }

    public Movie insertMovie(Movie movie){
        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "INSERT INTO movie (movie_name, genre, rating) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, movie.getMovie_name());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setLong(3, movie.getRating());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                int generated_movie_id = (int)rs.getLong(1);
                return new Movie(
                        generated_movie_id,
                        movie.getMovie_name(),
                        movie.getGenre(),
                        movie.getRating());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Movie> getMovieByRating(int rating){
        Connection connection = ConnectionSingleton.getConnection();
        List<Movie> moviesByRating = new ArrayList<>();

        try {
            String sql = "SELECT * FROM movie WHERE rating = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, rating);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Movie movie = new Movie(rs.getInt("movie_id"), rs.getString("movie_name"), rs.getString("genre"), rs.getInt("rating"));
                moviesByRating.add(movie);
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return moviesByRating;
    }

    public List<Movie> getMovieByGenre(String genre) {
        Connection connection = ConnectionSingleton.getConnection();
        List<Movie> moviesByGenre = new ArrayList<>();

        try{
            String sql = "SELECT * FROM movie WHERE genre = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, genre);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Movie movie = new Movie(rs.getInt("movie_id"), rs.getString("movie_name"), rs.getString("genre"), rs.getInt("rating"));
                moviesByGenre.add(movie);
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return moviesByGenre;
    }
}
