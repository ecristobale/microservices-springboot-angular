DROP TABLE IF EXISTS students;

CREATE TABLE students(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR (250) NOT NULL,
   surname VARCHAR (250) NOT NULL,
   email VARCHAR (250) NOT NULL UNIQUE,
   create_at TIMESTAMP NOT NULL
);