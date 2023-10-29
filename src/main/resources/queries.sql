CREATE TABLE IF NOT EXISTS employees(
	emp_id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    mobile VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    digital_add VARCHAR(100) NOT NULL,
    date_employd DATE,
    username VARCHAR(50) NOT NULL,
    `passwword` VARCHAR(255) NOT NULL,
    role_name VARCHAR(20) NOT NULL,
    date_added DATETIME DEFAULT CURRENT_TIMESTAMP,
    added_by INT DEFAULT 1
)AUTO_INCREMENT = 100;