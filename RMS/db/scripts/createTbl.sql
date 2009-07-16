DROP TABLE Administrator if exists
DROP TABLE Resources if exists
DROP TABLE Employees if exists


CREATE TABLE Administrator
(
	AdminId VARCHAR(5) PRIMARY KEY,
	Password VARCHAR(200) NOT NULL,
	UNIQUE (AdminId)	
)

CREATE TABLE Employees
(
	EmployeeId VARCHAR(5) PRIMARY KEY,
	Password VARCHAR(10) NOT NULL,
	Name VARCHAR(25) NOT NULL,
	Title VARCHAR(20) NOT NULL,
	Address VARCHAR(40) NOT NULL,
	PhoneNo INT NOT NULL,
	Email VARCHAR(25) NOT NULL,
	UNIQUE (EmployeeId)
)

CREATE TABLE Resources
(
	ResourceId VARCHAR(5) PRIMARY KEY,
	ResourceType VARCHAR(50) NOT NULL,
	ResourceName VARCHAR(50) NOT NULL,
	Status VARCHAR(150),
	Description VARCHAR(150),
	Purpose VARCHAR(5),
	EvaluatorId VARCHAR(5) ,
	Date_Entered DATE,
	Date_Required DATE,
	AuthorId VARCHAR(5),
	UNIQUE (ResourceId),	
	FOREIGN KEY (EvaluatorId) REFERENCES Employees (EmployeeId) ON DELETE CASCADE,
	FOREIGN KEY (AuthorId) REFERENCES Employees (EmployeeId) ON DELETE CASCADE
)