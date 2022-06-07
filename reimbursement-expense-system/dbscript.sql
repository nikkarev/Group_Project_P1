CREATE TABLE employee(
	employee_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	manager_id INT NOT NULL,
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	email VARCHAR(50),
	user_name VARCHAR(20),
	password VARCHAR(20),
	manager_type BOOLEAN NOT NULL	
);

CREATE TABLE reimbursement(
	reimbursement_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	employee_id INT REFERENCES employee(employee_id),
	manager_id INT REFERENCES employee(manager_id),
	status VARCHAR(25),,
	amount NUMERIC (6,2),
	reason VARCHAR(255)
);


INSERT INTO employee(manager_id, first_name, last_name, email, user_name, password, manager_type) 
VALUES(1, 'John', 'Smith', 'johnsmith@gmail.com', 'jsmith123', 'dogsaregreat456', true); 

INSERT INTO employee(manager_id, first_name, last_name, email, user_name, password, manager_type) 
VALUES(1, 'Bradly', 'Cooper', 'patrickson@gmail.com', 'bradpotter@gmail.com', 'catsarecool789', false); 

INSERT INTO employee(manager_id, first_name, last_name, email, user_name, password, manager_type) 
VALUES(1, 'Patrick', 'Son', 'patrickson@gmail.com', 'patrickson', 'pat123', false); 


--Reimbursement Queries
INSERT INTO reimbursement(employee_id, manager_id, status, amount, reason)
VALUES(2, 1, 'Pending', 500.00, 'Travel Expenses');

INSERT INTO reimbursement(employee_id, manager_id, status, amount, reason)
VALUES(24, 1, 'Approve', 300.00, 'Meal Expenses');