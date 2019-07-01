SET MODE PostgreSQL;
 CREATE TABLE IF NOT EXISTS rangers(
    id int PRIMARY KEY auto_increment,
    ranger VARCHAR,
     badge int
 );

 CREATE TABLE IF NOT EXISTS locations(
    id int PRIMARY KEY auto_increment,
    location VARCHAR,
 );


 CREATE TABLE IF NOT EXISTS species(
    id int PRIMARY KEY auto_increment,
    the_name VARCHAR,
 );

 CREATE TABLE IF NOT EXISTS animals(
    id int PRIMARY KEY auto_increment,
    the_name VARCHAR,
    endangered boolean
 );
