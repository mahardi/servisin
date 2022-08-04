CREATE DATABASE IF NOT EXISTS servisin;
GRANT ALL PRIVILEGES ON servisin.* TO db_user@localhost IDENTIFIED BY 'db_user';

USE servisin;

CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  car_id INT(4) UNSIGNED NOT NULL,
  visit_date DATE,
  description VARCHAR(8192),
  FOREIGN KEY (car_id) REFERENCES cars(id)
) engine=InnoDB;
