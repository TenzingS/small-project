package Controller;

import Model.Movie;

import Service.MovieService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;


import java.util.List;

public class MovieController {
    MovieService movieService;

    public MovieController(){
        this.movieService = new MovieService();
    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.get("/movies", this::getAllMoviesHandler);
        app.post("/movies", this::postMoviesHandler);
        app.get("/movies/<rating>", this::getMoviesByRatingHandler);
        app.get("/movies/<genre>", this::getMoviesByGenresHandler);
        return app;
    }

    private void getAllMoviesHandler(Context ctx) {
        List<Movie> movies = movieService.getAllMovies();
        ctx.json(movies);
    }

    private void postMoviesHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Movie movie = om.readValue(ctx.body(), Movie.class);
        Movie createdMovie = movieService.createMovie(movie);
        if(createdMovie != null){
            ctx.json(om.writeValueAsString(createdMovie));
        }else{
            ctx.status(400);
        }
    }

    private void getMoviesByRatingHandler(Context ctx) {
        int rating = Integer.parseInt(ctx.pathParam("rating"));
        List<Movie> moviesByRating = movieService.getMovieByRating(rating);
        ctx.json(moviesByRating);
    }


    private void getMoviesByGenresHandler(Context ctx) {
        String genre = ctx.pathParam("genre");
        List<Movie> moviesByGenre = movieService.getMovieByGenre(genre);
        ctx.json(moviesByGenre);
    }

}
