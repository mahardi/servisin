INSERT IGNORE INTO workshops(id, name) VALUES (1, 'Green Performance');
INSERT IGNORE INTO workshops(id, name) VALUES (2, 'Red Wheels');
INSERT IGNORE INTO workshops(id, name) VALUES (3, 'Blue Audio');

INSERT IGNORE INTO specialties(id, name) VALUES (1, 'Performance Tuning');
INSERT IGNORE INTO specialties(id, name) VALUES (2, 'Spooring and Balancing');
INSERT IGNORE INTO specialties(id, name) VALUES (3, 'Audio');

INSERT IGNORE INTO workshop_specialties(workshop_id, specialty_id) VALUES (1, 1);
INSERT IGNORE INTO workshop_specialties(workshop_id, specialty_id) VALUES (2, 2);
INSERT IGNORE INTO workshop_specialties(workshop_id, specialty_id) VALUES (3, 3);
