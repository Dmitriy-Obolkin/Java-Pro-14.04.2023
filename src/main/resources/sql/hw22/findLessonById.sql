SELECT
	l.id AS lesson_Id,
    l.name AS lesson_Name,
    l.updatedAt,
    l.homework_id,
    hw.name AS homework_name,
    hw.description AS homework_description
FROM
	Lesson l
LEFT JOIN
	Homework hw ON l.homework_id = hw.id
WHERE
	l.id = ?;