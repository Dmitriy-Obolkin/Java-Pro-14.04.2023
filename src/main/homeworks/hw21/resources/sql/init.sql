 USE Hillel_HW;
-- SHOW TABLES;

-- CREATE TABLE Homework (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255),
--     description TEXT
-- );

-- CREATE TABLE Lesson (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255),
--     updatedAt DATETIME,
--     homework_id INT,
--     FOREIGN KEY (homework_id) REFERENCES Homework(id)
-- );

-- CREATE TABLE Schedule (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255),
--     updatedAt DATETIME
-- );

-- CREATE TABLE LessonSchedule (
--     lesson_id INT,
--     schedule_id INT,
--     PRIMARY KEY (lesson_id, schedule_id),
--     FOREIGN KEY (lesson_id) REFERENCES Lesson(id),
--     FOREIGN KEY (schedule_id) REFERENCES Schedule(id)
-- );

-- SELECT * FROM HOMEWORK;
-- INSERT INTO Homework (name, description)
-- VALUES 
--     ('Homework 1', 'This is the first homework'),
--     ('Homework 2', 'This is the second homework'),
--     ('Homework 3', 'This is the third homework');

-- SELECT * FROM Lesson;
-- INSERT INTO Lesson (name, updatedAt, homework_id)
-- VALUES 
--     ('Lesson 1', '2023-04-14 12:00:00', 1),
--     ('Lesson 2', '2023-06-30 19:15:00', 2),
--     ('Lesson 3', NOW(), 3);

-- SELECT * FROM Schedule;
-- INSERT INTO Schedule (name, updatedAt)
-- VALUES 
--     ('Schedule 1', '2023-04-18 12:00:00'),
--     ('Schedule 2', NOW()),
--     ('Schedule 3', NOW());

-- SELECT * FROM LessonSchedule;
-- INSERT INTO LessonSchedule (lesson_id, schedule_id)
-- VALUES 
--     (1, 1),
--     (1, 2),
--     (2, 2),
--     (2, 3),
--     (3, 1),
--     (3, 3);

    
    
    
    
    
    

