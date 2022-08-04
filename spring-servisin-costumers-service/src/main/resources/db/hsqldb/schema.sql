DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(12)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE cars (
  id            INTEGER IDENTITY PRIMARY KEY,
  name          VARCHAR(30),
  dateOfPurchase          DATE,
  license_plate VARCHAR(30)
  type_id       INTEGER NOT NULL,
  owner_id      INTEGER NOT NULL
);
ALTER TABLE cars ADD CONSTRAINT fk_cars_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE cars ADD CONSTRAINT fk_cars_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX cars_name ON cars (name);