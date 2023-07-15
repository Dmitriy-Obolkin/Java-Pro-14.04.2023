USE Hillel_HW;

SHOW TABLES;

 CREATE TABLE Homework (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),
     description TEXT
 );
 
 CREATE TABLE Lesson (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),
     updatedAt DATETIME,
     homework_id INT,
     FOREIGN KEY (homework_id) REFERENCES Homework(id)
 );
