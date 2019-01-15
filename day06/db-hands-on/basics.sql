-- task 0
DROP TABLE INSTRUCTOR;

-- task 1
CREATE TABLE INSTRUCTOR(
	ins_id INTEGER CONSTRAINT instructor_pk PRIMARY KEY NOT NULL,
	firstname VARCHAR(15) NOT NULL,
	lastname VARCHAR(15) NOT NULL,
	city VARCHAR(20),
	country CHAR(2)
);

-- task 2
-- Careful with strings. They are delimited by single quotes rather than 
INSERT INTO INSTRUCTOR
	(ins_id, firstname, lastname, city, country)
VALUES
	(1, 'Jeanderson', 'Barros Candido', 'Joao Pessoa', 'BR');

-- Inserting multiple values:
INSERT INTO INSTRUCTOR
	(ins_id, firstname, lastname, city, country)
VALUES
	(2, 'Mauricio', 'da Silva', 'Sao Paulo', 'BR'),
	(3, 'John', 'Petrucci', 'Long Island', 'NY');

SELECT * FROM INSTRUCTOR;

-- task 3	
SELECT firstname, lastname FROM INSTRUCTOR
	WHERE country = 'BR';

-- task 4
UPDATE INSTRUCTOR
SET firstname = 'Joao'
WHERE firstname = 'Mauricio';

SELECT * FROM INSTRUCTOR;

-- task 5
DELETE FROM INSTRUCTOR WHERE ins_id = 2;

SELECT * FROM INSTRUCTOR;

