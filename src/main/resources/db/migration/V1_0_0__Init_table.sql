CREATE TABLE IF NOT EXISTS course_units
(
    id               SERIAL,
    course_unit_name VARCHAR(50) NOT NULL,
    unit_order       INTEGER     NOT NULL,
    course_id        INTEGER     NOT NULL,
    CONSTRAINT pk_course_units_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course_units_lessons
(
    id             SERIAL,
    course_unit_id INTEGER NOT NULL,
    lesson_id      INTEGER NOT NULL,
    lesson_order   INTEGER,
    CONSTRAINT pk_course_units_lessons_id PRIMARY KEY (id),
    CONSTRAINT fk_course_unit_id_id FOREIGN KEY (course_unit_id) REFERENCES course_units (id)
);

INSERT INTO course_units (id, course_unit_name, unit_order, course_id)
VALUES (1, 'Основы программирования', 1, 1);

INSERT INTO course_units_lessons (id, course_unit_id, lesson_id, lesson_order)
VALUES (1, 1, 1, 1),
       (2, 1, 2, 2),
       (3, 1, 3, 3),
       (4, 1, 4, 4),
       (5, 1, 5, 5),
       (6, 1, 6, 6),
       (7, 1, 7, 7),
       (8, 1, 8, 8),
       (9, 1, 9, 9),
       (10, 1, 10, 10),
       (11, 1, 11, 11),
       (12, 1, 12, 12),
       (13, 1, 13, 13);