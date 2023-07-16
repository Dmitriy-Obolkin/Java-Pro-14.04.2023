SELECT
    hw.id as homework_id,
    hw.name AS homework_name,
    hw.description AS homework_description
FROM
	Homework hw
WHERE
	hw.id = ?;