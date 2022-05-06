# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db

CREATE DATABASE IF NOT EXISTS movies_db;


# 4. use the movies_db


USE movies_db;

# 5. drop the table(s) to which no other tables are dependent (none at first)

DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;


# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

CREATE TABLE IF NOT EXISTS directors
(

    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)
);
DESCRIBE directors;

CREATE TABLE IF NOT EXISTS movies
(
    id          int unsigned not null auto_increment,
    title       varchar(120),
    year        char(4),
    plot        text,
    poster      text,
    rating      char(1),
    director_id int unsigned not null,
#     genre_id int unsigned not null,
    primary key (id),
    foreign key (director_id) references directors (id)
#     foreign key (genre_id) references genre (id)
);

DESCRIBE movies;

# 6a. Run the script to make sure it works

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!




