-- Удаление таблиц, если они существуют
DROP TABLE IF EXISTS employee_roles, patient, employee, department, roles;

-- Создание таблицы ролей
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       role_name VARCHAR(255) NOT NULL UNIQUE,
                       role_description VARCHAR(255)
);

-- Создание таблицы сотрудников
CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(30) NOT NULL,
                          lastname VARCHAR(30) NOT NULL,
                          patronymic VARCHAR(255),
                          position VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          dateOfEmployment DATE,
                          department_id INT  -- Добавлено сразу сюда для компактности
);

-- Создание таблицы отделов
CREATE TABLE department (
                            id SERIAL PRIMARY KEY,
                            department_name VARCHAR(255) NOT NULL UNIQUE,
                            department_description VARCHAR(255) NOT NULL,
                            department_manager INT,
                            CONSTRAINT fk_department_manager FOREIGN KEY (department_manager) REFERENCES employee(id)
);

-- Добавление внешнего ключа для связи сотрудника с отделом
ALTER TABLE employee
    ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id);

-- Таблица связи между сотрудниками и ролями
CREATE TABLE employee_roles (
                                employee_id INT NOT NULL,
                                role_id INT NOT NULL,
                                PRIMARY KEY (employee_id, role_id),
                                CONSTRAINT fk_emp_role_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
                                CONSTRAINT fk_emp_role_role FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Таблица пациентов
CREATE TABLE patient (
                         id SERIAL PRIMARY KEY,
                         namePatient VARCHAR(30) NOT NULL,
                         lastnamePatient VARCHAR(30) NOT NULL,
                         middleNamePatient VARCHAR(255),
                         gender VARCHAR(10) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         phone_number_patient VARCHAR(12) NOT NULL,
                         birth_date_patient DATE NOT NULL,
                         snils_patient VARCHAR(11) NOT NULL UNIQUE,
                         policy_number_patient VARCHAR(16) NOT NULL UNIQUE
);
