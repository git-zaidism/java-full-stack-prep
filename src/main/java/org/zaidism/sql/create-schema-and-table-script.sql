-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS Employees;

-- Use the created database
USE Employees;

-- Create the Department table
CREATE TABLE IF NOT EXISTS Dept (
    dept_id   VARCHAR(3) PRIMARY KEY,
    dept_name VARCHAR(20)
);

-- Create the Employee table
CREATE TABLE IF NOT EXISTS Emp (
    emp_id     INT PRIMARY KEY,
    emp_name   VARCHAR(50),
    salary     INT,
    dept_id    VARCHAR(3),
    manager_id INT,
    FOREIGN KEY (dept_id) REFERENCES Dept(dept_id),
    FOREIGN KEY (manager_id) REFERENCES Emp(emp_id)
);

-- Create the Manager table
CREATE TABLE IF NOT EXISTS Manager (
    manager_id   INT PRIMARY KEY,
    manager_name VARCHAR(50),
    dept_id      VARCHAR(3),
    FOREIGN KEY (dept_id) REFERENCES Dept(dept_id)
);

-- Create the Project table
CREATE TABLE IF NOT EXISTS Project (
    project_id   VARCHAR(20) PRIMARY KEY,
    project_name VARCHAR(100)
);

-- Create the TeamMember table
CREATE TABLE IF NOT EXISTS TeamMember (
    team_member_id INT,
    project_id     VARCHAR(20),
    PRIMARY KEY (team_member_id, project_id),
    FOREIGN KEY (team_member_id) REFERENCES Emp(emp_id),
    FOREIGN KEY (project_id) REFERENCES Project(project_id)
);

-- Insert data into the Department table
INSERT INTO Dept (dept_id, dept_name)
VALUES ('D1', 'IT'),
       ('D2', 'HR'),
       ('D3', 'Finance'),
       ('D4', 'Admin'),
       ('D10', 'Other');

-- Insert data into the Employee table
INSERT INTO Emp (emp_id, emp_name, salary, dept_id)
VALUES (1, 'Rahul', 15000, 'D1'),
       (2, 'Manoj', 15000, 'D1'),
       (3, 'James', 55000, 'D2'),
       (4, 'Michael', 25000, 'D2'),
       (5, 'All', 20000, 'D10'),
       (6, 'Robin', 35000, 'D10'),
       (7, 'David', 40000, 'D3'),
       (8, 'Jessica', 30000, 'D3'),
       (9, 'Ethan', 28000, 'D4'),
       (10, 'Olivia', 32000, 'D4'),
       (11, 'Noah', 45000, 'D2'),
       (12, 'Mia', 22000, 'D1'),
       (13, 'William', 38000, 'D3'),
       (14, 'Emma', 25000, 'D4'),
       (15, 'Lucas', 42000, 'D2'),
       (16, 'Charlotte', 34000, 'D10'),
       (17, 'Aiden', 20000, 'D4'),
       (18, 'Sofia', 31000, 'D1'),
       (19, 'Logan', 29000, 'D3'),
       (20, 'Isabella', 40000, 'D4');

-- Insert data into the Manager table
INSERT INTO Manager (manager_id, manager_name, dept_id)
VALUES (1, 'Prem', 'D3'),
       (2, 'Shripadh', 'D4'),
       (3, 'Nick', 'D1'),
       (4, 'Cory', 'D1'),
       (5, 'Mary', 'D1');

-- Insert data into the Project table
INSERT INTO Project (project_id, project_name)
VALUES ('P1', 'Data Migration'),
       ('P2', 'ETL Tool');

-- Insert data into the TeamMember table
INSERT INTO TeamMember (team_member_id, project_id)
VALUES (1, 'P1'),
       (2, 'P1'),
       (3, 'P1'),
       (4, 'P1'),
       (5, 'P1'),
       (6, 'P1'),
       (1, 'P2'),
       (2, 'P2'),
       (3, 'P2'),
       (4, 'P2');
