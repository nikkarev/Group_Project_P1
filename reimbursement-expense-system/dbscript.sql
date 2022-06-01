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
