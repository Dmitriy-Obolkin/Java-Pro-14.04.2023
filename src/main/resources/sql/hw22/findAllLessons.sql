SELECT
	l.id AS lesson_id,
    l.name AS lesson_name,
    l.updatedAt,
    l.homework_id,
    hw.name AS homework_name,
    hw.description AS homework_description
FROM
	Lesson l
LEFT JOIN
	Homework hw ON l.homework_id = hw.id;