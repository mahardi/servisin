DROP TABLE visits IF EXISTS;

CREATE TABLE visits (
  id          INTEGER IDENTITY PRIMARY KEY,
  car_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(8192)
);

CREATE INDEX visits_car_id ON visits (car_id);
