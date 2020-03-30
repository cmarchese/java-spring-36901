BEGIN;

CREATE SCHEMA IF NOT EXISTS dbo;

USE dbo;

CREATE TABLE IF NOT EXISTS tasks (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(120) DEFAULT NULL,
  description varchar(120) DEFAULT NULL,
  due_date timestamp,
  task_status varchar(30),
  PRIMARY KEY (`id`)
);

COMMIT;