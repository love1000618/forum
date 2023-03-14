CREATE DATABASE forum;

USE forum;
CREATE TABLE comment(id INT PRIMARY KEY AUTO_INCREMENT,
                     content VARCHAR(100),forum_id INT,
                     user_id INT,created TIMESTAMP);

CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT,
                  username VARCHAR(50),password VARCHAR(50),nickname VARCHAR(50));


CREATE TABLE forum(id INT PRIMARY KEY AUTO_INCREMENT,
                   title VARCHAR(50),
                   content VARCHAR(255),
                   urls TEXT,
                   created TIMESTAMP,
                   user_id INT,
                   category_id INT);

CREATE TABLE category (id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(50) );