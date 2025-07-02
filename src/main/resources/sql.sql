CREATE TABLE employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(30) NOT NULL,
                          lastname VARCHAR(30) NOT NULL,
                          patronymic VARCHAR(255),
                          position VARCHAR(255) NOT NULL,
                          department_id BIGINT,
                          email VARCHAR(255) NOT NULL,
                          dateOfEmployment DATE,
                          role_id BIGINT
);

CREATE TABLE department (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL UNIQUE,
                            description VARCHAR(255),
                            manager_id INT
);

CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE,
                       description VARCHAR(255)
);

-- Добавляем внешние ключи после создания таблиц:
ALTER TABLE employee
    ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id);

ALTER TABLE employee
    ADD CONSTRAINT fk_employee_role FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE department
    ADD CONSTRAINT fk_department_manager FOREIGN KEY (manager_id) REFERENCES employee(id);
