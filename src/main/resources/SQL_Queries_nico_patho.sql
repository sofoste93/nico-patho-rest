CREATE DATABASE nicotine_pathology;

USE nicotine_pathology;

-- Table Disease
CREATE TABLE Disease (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT NOT NULL
);

-- Table Firm
CREATE TABLE Firm (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      headquarters VARCHAR(255) NOT NULL,
                      annualRevenue DOUBLE NOT NULL,
                      annualTax DOUBLE NOT NULL,
                      annualProfit DOUBLE NOT NULL
);

-- Table Product
CREATE TABLE Product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         brandName VARCHAR(255) NOT NULL,
                         nicotineContent DOUBLE NOT NULL,
                         tarContent DOUBLE NOT NULL,
                         condensateContent DOUBLE NOT NULL,
                         firm_id BIGINT,
                         FOREIGN KEY (firm_id) REFERENCES Firm(id) -- Ensure unique constraint name
);

-- Table Product_Disease (for many-to-many relationship between Product and Disease)
CREATE TABLE ProductDisease (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  product_id BIGINT NOT NULL,
  disease_id BIGINT NOT NULL,
  riskLevel VARCHAR(255) DEFAULT NULL,
  UNIQUE KEY (product_id, disease_id),
  KEY disease_id (disease_id),
  CONSTRAINT ProductDisease_ibfk_1 FOREIGN KEY (product_id) REFERENCES Product (id),
  CONSTRAINT ProductDisease_ibfk_2 FOREIGN KEY (disease_id) REFERENCES Disease (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insertion de données dans la table Disease
INSERT INTO Disease (name, description) VALUES
    ('Lung Cancer', 'A type of cancer that is highly associated with tobacco smoking.'),
    ('Chronic Bronchitis', 'A chronic inflammatory condition of the lungs caused by smoking.'),
    ('Heart Disease', 'Diseases of the heart linked to smoking include heart attacks and heart failure.'),
    ('Chronic Obstructive Pulmonary Disease (COPD)', 'COPD is a chronic inflammatory lung disease that obstructs airflow from the lungs.'),
    ('Coronary Heart Disease', 'Coronary heart disease (CHD) is a condition where the coronary arteries, which supply oxygen-rich blood to your heart muscle, become narrow due to a buildup of plaque.'),
    ('Kehlkopfkrebs', 'Ein Krebs, der stark mit dem Rauchen in Verbindung gebracht wird und den Kehlkopf betrifft.'),
    ('Speiseröhrenkrebs', 'Eine Krebsart, die mit dem Konsum von Tabakprodukten assoziiert ist und die Speiseröhre betrifft.'),
    ('Blasenkrebs', 'Eine Krebsart, die mit dem Rauchen verbunden ist und die Blase betrifft.'),
    ('Bauchspeicheldrüsenkrebs', 'Eine Krebsart, die stark mit dem Tabakkonsum in Verbindung steht und die Bauchspeicheldrüse betrifft.'),
    ('Mundkrebs', 'Ein Krebs, der durch den Konsum von Tabak verursacht wird und den Mundbereich betrifft.'),
    ('Asthma', 'Eine chronische Erkrankung, die durch entzündete und verengte Atemwege gekennzeichnet ist und durch Rauchen verschlimmert werden kann.'),
    ('Emphysem', 'Eine langfristige, progressive Lungenerkrankung, die die Atemwege und Alveolen schädigt.'),
    ('Fertilitätsprobleme', 'Probleme mit der Fruchtbarkeit, die durch Nikotinkonsum und Rauchen verursacht werden.'),
    ('Niedriges Geburtsgewicht', 'Ein Zustand, bei dem Babys mit einem geringeren Gewicht als normal geboren werden, oft durch Rauchen in der Schwangerschaft verursacht.'),
    ('Frühgeburten', 'Geburten, die vor dem erwarteten Termin erfolgen und durch Rauchen in der Schwangerschaft verursacht werden können.');

-- Insertion de données dans la table Firm
INSERT INTO Firm (name, headquarters, annualRevenue, annualTax, annualProfit) VALUES
    ('Tabak AG', 'Berlin', 5000000.00, 750000.00, 450000.00),
    ('Ciggy Ltd', 'Munich', 3000000.00, 450000.00, 250000.00),
    ('SmokeFree Inc.', 'Stuttgart', 7000000.00, 1050000.00, 350000.00),
    ('Tobacco SA', 'New York', 6000000.00, 900000.00, 400000.00),
    ('Tobacco GmbH', 'Berlin', 4000000.00, 600000.00, 300000.00),
    ('Tobacco Company A', 'Heven', 8000000.00, 1200000.00, 500000.00),
    ('Rauchfrei GmbH', 'Hamburg', 3500000.00, 525000.00, 275000.00),
    ('Nikotinfrei AG', 'Frankfurt', 4800000.00, 720000.00, 380000.00),
    ('Gesundheit Tabak GmbH', 'Köln', 5600000.00, 840000.00, 420000.00),
    ('Nikotin GmbH', 'Düsseldorf', 2900000.00, 435000.00, 230000.00),
    ('Tabak Berlin AG', 'Berlin', 3300000.00, 495000.00, 310000.00),
    ('SmokeLess GmbH', 'Leipzig', 4100000.00, 615000.00, 340000.00);

-- Insertion de données dans la table Product
INSERT INTO Product (brandName, nicotineContent, tarContent, condensateContent, firm_id) VALUES
    ('Smooth Smoke', 1.2, 15.0, 12.0, 1),
    ('Light Air', 0.8, 12.0, 8.0, 2),
    ('Heavy Cloud', 1.5, 20.0, 18.0, 3),
    ('Strong Puff', 1.3, 16.0, 14.0, 4),
    ('Mild Mist', 0.9, 10.0, 7.0, 5),
    ('Dense Haze', 1.6, 22.0, 19.0, 6),
    ('Clear Air', 0.7, 9.0, 6.0, 7),
    ('Pure Breath', 0.6, 8.0, 5.0, 8),
    ('Fresh Puff', 1.0, 14.0, 10.0, 9),
    ('Light Mist', 0.5, 7.0, 4.0, 10),
    ('Silent Smoke', 1.1, 13.0, 11.0, 11),
    ('Soft Cloud', 1.2, 11.0, 9.0, 12);

-- Insertion de données dans la table ProductDisease
INSERT INTO ProductDisease (product_id, disease_id, riskLevel) VALUES
    (1, 1, 'High'),
    (1, 2, 'Moderate'),
    (1, 3, 'High'),
    (2, 1, 'Moderate'),
    (2, 2, 'Low'),
    (3, 1, 'High'),
    (3, 4, 'High'),
    (4, 5, 'Moderate'),
    (5, 3, 'Low'),
    (6, 2, 'High'),
    (7, 6, 'Moderate'),
    (7, 7, 'High'),
    (8, 8, 'Moderate'),
    (8, 9, 'Low'),
    (9, 10, 'Moderate'),
    (10, 1, 'Low'),
    (10, 2, 'Low'),
    (11, 3, 'High'),
    (11, 4, 'High'),
    (12, 5, 'Moderate');


-- solving duplicate foreign_key constraint issue...
-- ALTER TABLE Product DROP FOREIGN KEY FKr87quxe6ptebktlybko00tarb;
-- ALTER TABLE Product DROP FOREIGN KEY FKr87quxe6ptebktlybko00tarb;

-- ALTER TABLE Product ADD CONSTRAINT FK_Firm_Product FOREIGN KEY (firm_id) REFERENCES Firm(id);


