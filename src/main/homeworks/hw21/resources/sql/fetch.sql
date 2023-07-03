USE Hillel_HW;


-- a
SELECT 
	* 
FROM 
	HOMEWORK;


-- b
SELECT 
	* 
FROM 
	Lesson l
LEFT JOIN 
	Homework hw ON l.homework_id = hw.id;


-- 	c 
SELECT 
	* 
FROM 
	Lesson l
LEFT JOIN 
	Homework hw ON l.homework_id = hw.id
ORDER BY 
	l.updatedAt;


-- d 
SELECT 
	* 
FROM 
	Schedule s
LEFT JOIN 
	LessonSchedule ls ON s.id = ls.schedule_id
LEFT JOIN 
	Lesson l ON l.id = ls.lesson_id;


-- e
SELECT 
    s.id AS schedule_id,
    s.name AS schedule_name,
    COUNT(ls.lesson_id) AS lesson_count
FROM 
    Schedule s
LEFT JOIN 
    LessonSchedule ls ON s.id = ls.schedule_id
GROUP BY 
    s.id, 
    s.name;