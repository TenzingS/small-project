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
            String sql = "SELECT * FROM movies";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Movie movie = new Movie(rs.getInt("movie_id"), rs.getString("movie_name"), rs.getInt("rating"), rs.getString("genre"));
                allMovies.add(movie);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


        return allMovies;
    }

    public Movie getMovieByGenre(String genre) {
        Connection connection = ConnectionSingleton.getConnection();
        List<Movie> moviesByGenre = new ArrayList<>();

        try{
            String sql = "SELECT * FROM movie WHERE genre = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, genre);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Movie movie = new Movie(rs.getInt("movie_id"), rs.getString("movie_name"), rs.getInt("rating"), rs.getString("genre"));
                moviesByGenre.add(movie);
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return moviesByGenre;
    }
}
