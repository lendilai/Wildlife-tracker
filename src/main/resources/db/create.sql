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