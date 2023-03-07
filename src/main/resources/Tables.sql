--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables

drop table if exists movie;
drop table if exists rating;

create table movie(
    movie_id int primary_key auto_increment,
    movie_name varchar(255),
    genre varchar(255),
    rating int
);