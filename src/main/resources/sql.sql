DROP TABLE IF EXISTS roles, employee, department, patient;
CREATE TABLE roles (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(255) NOT NULL UNIQUE,
                       role_description VARCHAR(255)
);

CREATE TABLE employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(30) NOT NULL,
                          lastname VARCHAR(30) NOT NULL,
                          patronymic VARCHAR(255),
                          position VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          dateOfEmployment DATE
);

CREATE TABLE department (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            department_name VARCHAR(255) NOT NULL UNIQUE,
                            department_description VARCHAR(255) NOT NULL,
                            department_manager INT,
                            CONSTRAINT fk_department_manager FOREIGN KEY (department_manager) REFERENCES employee(id)
);

ALTER TABLE employee
    ADD COLUMN department_id BIGINT;

ALTER TABLE employee
    ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id);

CREATE TABLE employee_roles (
                                employee_id INT NOT NULL,
                                role_id INT NOT NULL,
                                PRIMARY KEY (employee_id, role_id),
                                CONSTRAINT fk_emp_role_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
                                CONSTRAINT fk_emp_role_role FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE patient (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         namePatient VARCHAR(30) NOT NULL,
                         lastnamePatien VARCHAR(30) NOT NULL,
                         middleNamePatient VARCHAR(255),
                         gender VARCHAR(10) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         phone_number_patient VARCHAR(12) NOT NULL,
                         birth_date_patient DATE NOT NULL,
                         snils_patient VARCHAR(11) NOT NULL UNIQUE,
                         policy_number_patient VARCHAR(16) NOT NULL UNIQUE
);
