CREATE DATABASE IF NOT EXISTS servisin;
GRANT ALL PRIVILEGES ON servisin.* TO db_user@localhost IDENTIFIED BY 'db_user';

USE servisin;

CREATE TABLE IF NOT EXISTS workshops (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS workshop_specialties (
  workshop_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (workshop_id) REFERENCES workshops(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (workshop_id,specialty_id)
) engine=InnoDB;
