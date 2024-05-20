CREATE DATABASE nicotine_pathology;

USE nicotine_pathology;

CREATE TABLE Disease (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);

CREATE TABLE Firm (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    headquarters VARCHAR(255),
    annualRevenue DOUBLE,
    annualTax DOUBLE,
    annualProfit DOUBLE
);

CREATE TABLE Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brandName VARCHAR(255),
    nicotineContent DOUBLE,
    tarContent DOUBLE,
    condensateContent DOUBLE
);

-- Insertion de données dans la table Disease
INSERT INTO Disease (name, description) VALUES
('Lung Cancer', 'A type of cancer that is highly associated with tobacco smoking.'),
('Chronic Bronchitis', 'A chronic inflammatory condition of the lungs caused by smoking.'),
('Heart Disease', 'Diseases of the heart linked to smoking include heart attacks and heart failure.');

-- Insertion de données dans la table Firm
INSERT INTO Firm (name, headquarters, annualRevenue, annualTax, annualProfit) VALUES
('Tabak AG', 'Berlin', 5000000.00, 750000.00, 450000.00),
('Ciggy Ltd', 'Munich', 3000000.00, 450000.00, 250000.00),
('SmokeFree Inc.', 'Stuttgart', 7000000.00, 1050000.00, 350000.00);

-- Insertion de données dans la table Product
INSERT INTO Product (brandName, nicotineContent, tarContent, condensateContent) VALUES
('Smooth Smoke', 1.2, 15.0, 12.0),
('Light Air', 0.8, 12.0, 8.0),
('Heavy Cloud', 1.5, 20.0, 18.0);


# quelques donnees pour besoin de test
# Disease
INSERT INTO Disease (name, description) 
VALUES ('Lung Cancer', 'A type of cancer that begins in the lungs.');
INSERT INTO Disease (name, description) 
VALUES ('Chronic Obstructive Pulmonary Disease (COPD)', 'COPD is a chronic inflammatory lung disease that obstructs airflow from the lungs.');
INSERT INTO Disease (name, description) 
VALUES ('Coronary Heart Disease', 'Coronary heart disease (CHD) is a condition where the coronary arteries, which supply oxygen-rich blood to your heart muscle, become narrow due to a buildup of plaque.');
# Firm
INSERT INTO Firm (name, headquarters) 
VALUES ('Tobacco SA', 'New York');
INSERT INTO Firm (name, headquarters) 
VALUES ('Tobacco GmbH', 'Berlin');
INSERT INTO Firm (name, headquarters) 
VALUES ('Tobacco Company A', 'Heven');
# Product
#INSERT INTO Product (name, type, manufacturer)
#VALUES ('Cigarette A', 'Cigarette', 'Tobacco SA');
#INSERT INTO Product (name, type, manufacturer)
#VALUES ('Cigarette B', 'Cigarette', 'Tobacco GmbH');
#INSERT INTO Product (name, type, manufacturer)
#VALUES ('Cigarette C', 'Cigarette', 'Tobacco Company A');
