INSERT INTO types(id, name) VALUES (1, 'SUV');
INSERT INTO types(id, name) VALUES (2, 'Mini Van');
INSERT INTO types(id, name) VALUES (3, 'Coupe');
INSERT INTO types(id, name) VALUES (4, 'Sport');
INSERT INTO types(id, name) VALUES (5, 'Truck');
INSERT INTO types(id, name) VALUES (6, 'Sedan');

INSERT INTO owners(id, first_name, last_name, address, city, telephone) VALUES (1, 'Rama', 'Utama', 'Jl. Poso', 'Jakarta Utara', '621812314');
INSERT INTO owners(id, first_name, last_name, address, city, telephone) VALUES (2, 'Romli', 'Anwar', 'Jl. Blitar Raya', 'Jakarta Timur', '628512312');
INSERT INTO owners(id, first_name, last_name, address, city, telephone) VALUES (3, 'Bianca', 'Putri', 'Jl. Pulo Ribung', 'Bekasi', '6281431244');

INSERT INTO cars(id, date_of_purchase, license_plate, name, type_id, owner_id) VALUES (1, '2010-09-07', 'N1111', 'Jeep Wrangler', 1, 1);
INSERT INTO cars(id, date_of_purchase, license_plate, name, type_id, owner_id) VALUES (2, '2012-08-06', 'B123AAA', 'Suzuki Espass', 2, 2);
INSERT INTO cars(id, date_of_purchase, license_plate, name, type_id, owner_id) VALUES (3, '2011-04-17','B9314RFD', 'Honda Accord', 6, 3);