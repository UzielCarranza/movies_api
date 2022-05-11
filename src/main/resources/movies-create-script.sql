# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db


DROP database movies_db;

CREATE DATABASE IF NOT EXISTS movies_db;


# 4. use the movies_db


USE movies_db;

# 5. drop the table(s) to which no other tables are dependent (none at first)

DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS movie_actor;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS directors;
DROP TABLE IF EXISTS movies;

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties


# directors table
CREATE TABLE IF NOT EXISTS directors
(

    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)
);
DESCRIBE directors;

# genre
CREATE TABLE IF NOT EXISTS genre
(
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)
);
DESCRIBE genre;


# actors
CREATE TABLE IF NOT EXISTS actors
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)
);
DESCRIBE actors;


# movies tables
CREATE TABLE IF NOT EXISTS movies
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title       VARCHAR(120),
    year        CHAR(4),
    plot        TEXT,
    poster      TEXT,
    rating      CHAR(1),
    director_id INT UNSIGNED NOT NULL,
#     actor_id    INT UNSIGNED NOT NULL,
    genre_id    INT UNSIGNED NOT NULL,
#     directors   VARCHAR(255),
#     actors      VARCHAR(255),
#     genre       VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (director_id) REFERENCES directors (id),
    FOREIGN KEY (genre_id) REFERENCES genre (id)
#     FOREIGN KEY (actor_id) REFERENCES actors (id)
);

DESCRIBE movies;


CREATE TABLE IF NOT EXISTS movie_genre
(
    movie_id INT UNSIGNED NOT NULL,
    genre_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genre (id)

);
#
#
CREATE TABLE IF NOT EXISTS movie_actor
(
    movie_id INT UNSIGNED NOT NULL,
    actor_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (actor_id) REFERENCES actors (id)
);


# 6a. Run the script to make sure it works
#
# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script
#
# 8. Go add DROP IF EXIST statements for movies and directors
#
# 9. RUN IT!


# CREATE DATABASE IF NOT EXISTS movies_db;
#
# USE movies_db;
#
# CREATE TABLE IF NOT EXISTS movies(
#                                      id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#                                      title VARCHAR(255) NOT NULL,
#                                      year CHAR(4) NOT NULL,
#                                      plot TEXT,
#                                      poster TEXT,
#                                      rating CHAR(1),
#                                      directors VARCHAR(255),
#                                      actors VARCHAR(255),
#                                      genre VARCHAR(255),
#                                      PRIMARY KEY (id)
# );