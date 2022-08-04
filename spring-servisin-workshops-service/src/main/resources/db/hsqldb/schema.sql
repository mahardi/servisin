DROP TABLE workshop_specialties IF EXISTS;
DROP TABLE workshops IF EXISTS;
DROP TABLE specialties IF EXISTS;

CREATE TABLE workshops (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
);
CREATE INDEX workshops_name ON workshops (name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE workshop_specialties (
  workshop_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE workshop_specialties ADD CONSTRAINT fk_workshop_specialties_workshops FOREIGN KEY (workshop_id) REFERENCES workshops (id);
ALTER TABLE workshop_specialties ADD CONSTRAINT fk_workshop_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);
