drop database E13234Lab04;
CREATE DATABASE E13234Lab04;
USE E13234Lab04;

CREATE TABLE MOVIE (
  movie_id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  year YEAR NOT NULL,
  director VARCHAR(45),
  PRIMARY KEY (movie_id)
)
ENGINE = InnoDB;

CREATE TABLE REVIEWER (
  reviewer_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (reviewer_id))
ENGINE = InnoDB;


CREATE TABLE RATING (
  reviewer_id INT NOT NULL,
  movie_id INT NOT NULL,
  stars INT NOT NULL,
  rating_date DATE,
--  PRIMARY KEY (reviewer_id, movie_id),
  CONSTRAINT
    FOREIGN KEY (reviewer_id)
    REFERENCES REVIEWER (reviewer_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT
    FOREIGN KEY (movie_id)
    REFERENCES MOVIE (movie_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into MOVIE values('101','Gone with the Wind',1939,'Victor Fleming');
INSERT INTO MOVIE VALUES ('102', 'Star Wars', 1977, 'George Lucas');
INSERT INTO MOVIE  VALUES ('103', 'The Sound of Music', 1965, 'Robert Wise');
INSERT INTO MOVIE  VALUES ('104', 'E. T.', 1982, 'Steven Spielberg');
INSERT INTO MOVIE VALUES ('105', 'Titanic', 1997, 'James Cameron');
INSERT INTO MOVIE  VALUES ('106', 'Snow White', 1937, null);
INSERT INTO MOVIE  VALUES ('107', 'Avatar', 2009, 'James Cameron');
INSERT INTO MOVIE VALUES ('108', 'Raiders of the Lost Ark', 1981, 'Steven Spielberg');


INSERT INTO reviewer  VALUES ('201', 'Sarah Martinez');
INSERT INTO reviewer VALUES ('202', 'Daniel Lewis');
INSERT INTO reviewer  VALUES ('203', 'Brittany Harris');
INSERT INTO reviewer  VALUES ('204', 'Mike Anderson');
INSERT INTO reviewer  VALUES ('205', 'Chris Jackson');
INSERT INTO reviewer  VALUES ('206', 'Elizabeth Thomas');
INSERT INTO reviewer  VALUES ('207', 'James Cameron');
INSERT INTO reviewer  VALUES ('208', 'Ashley White');

INSERT INTO rating VALUES ('201', '101', '2', '2011-01-22');
INSERT INTO rating VALUES ('201', '101', '4', '2011-01-27');
INSERT INTO rating VALUES ('202', '106', '4',null);
INSERT INTO rating VALUES ('203', '103', '2', '2011-01-20');
INSERT INTO rating VALUES ('203', '108', '4', '2011-01-12');
INSERT INTO rating VALUES ('203', '108', '2', '2011-01-30');
INSERT INTO rating VALUES ('204', '101', '3', '2011-01-09');
INSERT INTO rating VALUES ('205', '103', '3', '2011-01-27');
INSERT INTO rating VALUES ('205', '104', '2', '2011-01-22');
INSERT INTO rating VALUES ('205', '108', '4', null);
INSERT INTO rating VALUES ('206', '107', '3', '2011-01-15');
INSERT INTO rating VALUES ('206', '106', '5', '2011-01-19');
INSERT INTO rating VALUES ('207', '107', '5', '2011-01-20');
INSERT INTO rating VALUES ('208', '104', '3', '2011-01-02');
-- (01)
SELECT * FROM movie;

-- (02)
SELECT * FROM MOVIE WHERE director = 'James Cameron';

-- (03)
SELECT * FROM MOVIE WHERE director = 'James Cameron' AND year >= 2000;

-- (04)
SELECT stars FROM rating;

-- (05)
SELECT DISTINCT stars FROM rating;

-- (06)
SELECT movie_id, director FROM MOVIE;

-- (07)
SELECT movie_id,title,year FROM MOVIE WHERE director='Steven Spielberg';

-- (08)
SELECT reviewer_id, movie_id FROM rating;

-- (09)
SELECT distinct reviewer_id, movie_id FROM rating;

-- (10)
SELECT * FROM reviewer WHERE name LIKE '%Martinez';

