CREATE USER 'srikanth'@'%' IDENTIFIED BY '17121981';
GRANT ALL PRIVILEGES ON *.* TO 'srikanth'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS 'demo1';
CREATE DATABASE 'demo1';
USE 'demo1';

CREATE TABLE 'login' (
  'user_id' int(11) NOT NULL AUTO_INCREMENT,
  'username' varchar(45) NOT NULL,
  'fullname' varchar(100) DEFAULT NULL,
  'email' varchar(100) DEFAULT NULL,
  'password' varchar(45) NOT NULL,
  PRIMARY KEY ('user_id')
);
CREATE TABLE 'todos' (
  'todo_id' int(11) NOT NULL AUTO_INCREMENT,
  'category' varchar(45) DEFAULT NULL,
  'description' varchar(45) DEFAULT NULL,
  'user_id' varchar(45) DEFAULT NULL,
  PRIMARY KEY ('todo_id')
);

CREATE TABLE 'Message' (
  'message_id' int(11) NOT NULL AUTO_INCREMENT,
  'topic' varchar(300) DEFAULT NULL,
  'description' varchar(845) DEFAULT NULL,
  'time' datetime NOT NULL,
  PRIMARY KEY ('message_id')
  );
