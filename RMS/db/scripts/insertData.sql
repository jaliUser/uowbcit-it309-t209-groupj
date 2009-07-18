--	Employees Table
INSERT INTO Employees
	(EmployeeId, Password, Name, Title, Address, PhoneNo, Email)
VALUES
	('T0001', 'password', 'Ben', 'CEO', '19A Hillview Avenue', '96727272', 'dnb@gmail.com');

--	Administrator Table
INSERT INTO Administrator
	(AdminId, Password)
VALUES
	('Admin', 'password');

--	Resources Table
INSERT INTO Resources
	(ResourceId, ResourceType, ResourceName, Status, Description)
VALUES
	('RS001', 'Reference', 'IT309 – System development & implementation', 'Functioning', 'Study guide version 1');
INSERT INTO Resources
	(ResourceId, ResourceType, ResourceName, Status, Description)
VALUES
	('RS002', 'Reference', 'IT310 – System implementation, 'Functioning', 'Study guide version 2');
