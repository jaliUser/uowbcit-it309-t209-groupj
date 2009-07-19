--the Employee, Administrator, and Resource table will be dropped if they exist before this script is run

DROP TABLE Resource IF EXISTS;
DROP TABLE Employee IF EXISTS;
DROP TABLE Administrator IF EXISTS;

CREATE TABLE Employee
(
	id VARCHAR(5) PRIMARY KEY,
	password VARCHAR(10) NOT NULL,
	name VARCHAR(25) NOT NULL,
	title VARCHAR(20) NOT NULL,
	address VARCHAR(40) NOT NULL,
	phone VARCHAR(8) NOT NULL,
	email VARCHAR(25) NOT NULL,
	UNIQUE (id)
)

CREATE TABLE Administrator
(
	id VARCHAR(5) PRIMARY KEY,
	password VARCHAR(200) NOT NULL,
	UNIQUE (id)	
)

CREATE TABLE Resource
(
	id VARCHAR(5) PRIMARY KEY ,
	type VARCHAR(50) NOT NULL,
	title VARCHAR(50) NOT NULL,
	status VARCHAR(150) NOT NULL,
	description VARCHAR(150),
	purpose VARCHAR(5),
	evaluator_id VARCHAR(5) ,
	date_entered DATE,
	date_required DATE,
	date_return DATE,
	author_id VARCHAR(5),
	comment VARCHAR(150),
	UNIQUE (id),	
	FOREIGN KEY (evaluator_id) REFERENCES Employee (id) ON DELETE CASCADE,
	FOREIGN KEY (author_id) REFERENCES Employee (id) ON DELETE CASCADE
)
