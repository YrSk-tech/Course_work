CREATE SCHEMA IF NOT EXISTS `ClinicDB` DEFAULT CHARACTER SET utf8 ;
USE `ClinicDB` ;
DROP TABLE IF EXISTS analysis;
DROP TABLE IF EXISTS technician;
DROP TABLE IF EXISTS labolatory;
DROP TABLE IF EXISTS clinic;
DROP TABLE IF EXISTS analysis_type;
DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;



CREATE TABLE IF NOT EXISTS `ClinicDB`.`clinic` (
  `clinic_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`clinic_id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`analysis_type` (
  `analysis_type_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`analysis_type_id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`labolatory` (
  `labolatory_id` INT NOT NULL AUTO_INCREMENT,
  `labolatory_number` INT NOT NULL,
  `clinic_id` INT NOT NULL,
  `analysis_type_id` INT NOT NULL,
  PRIMARY KEY (`labolatory_id`),
  INDEX `fk_labolatory_clinic_idx` (`clinic_id` ASC) VISIBLE,
  INDEX `fk_labolatory_analysis_type1_idx` (`analysis_type_id` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`doctor` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `clinic_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`doctor_id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`patient` (
  `patient_ssn` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`patient_ssn`),
  INDEX `fk_patient_doctor1_idx` (`doctor_id` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`analysis` (
  `analysis_id` INT NOT NULL AUTO_INCREMENT,
  `labolatory_id` INT NOT NULL,
  `analysis_type_id` INT NOT NULL,
  `patient_ssn` INT NOT NULL,
  PRIMARY KEY (`analysis_id`),
  INDEX `fk_analysis_labolatory1_idx` (`labolatory_id` ASC) VISIBLE,
  INDEX `fk_analysis_analysis_type1_idx` (`analysis_type_id` ASC) VISIBLE,
  INDEX `fk_analysis_patient1_idx` (`patient_ssn` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`diagnosis` (
  `diagnosis_id` INT NOT NULL AUTO_INCREMENT,
  `patient_ssn` INT NOT NULL,
  `patient_analysis` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`diagnosis_id`, `patient_ssn`),
  INDEX `fk_diagnosis_patient1_idx` (`patient_ssn` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ClinicDB`.`technician` (
  `technician_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `labolatory_id` INT NOT NULL,
  PRIMARY KEY (`technician_id`),
  INDEX `fk_technician_labolatory1_idx` (`labolatory_id` ASC) VISIBLE)
ENGINE = InnoDB;


ALTER TABLE labolatory
	ADD CONSTRAINT `fk_labolatory_clinic`
    FOREIGN KEY (`clinic_id`)
    REFERENCES `ClinicDB`.`clinic` (`clinic_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_labolatory_analysis_type1`
    FOREIGN KEY (`analysis_type_id`)
    REFERENCES `ClinicDB`.`analysis_type` (`analysis_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE patient
	ADD CONSTRAINT `fk_patient_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `ClinicDB`.`doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE analysis
	ADD CONSTRAINT `fk_analysis_labolatory1`
    FOREIGN KEY (`labolatory_id`)
    REFERENCES `ClinicDB`.`labolatory` (`labolatory_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_analysis_analysis_type1`
    FOREIGN KEY (`analysis_type_id`)
    REFERENCES `ClinicDB`.`analysis_type` (`analysis_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_analysis_patient1`
    FOREIGN KEY (`patient_ssn`)
    REFERENCES `ClinicDB`.`patient` (`patient_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE diagnosis
    ADD CONSTRAINT `fk_diagnosis_patient1`
    FOREIGN KEY (`patient_ssn`)
    REFERENCES `ClinicDB`.`patient` (`patient_ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
	
ALTER TABLE technician
    ADD CONSTRAINT `fk_technician_labolatory1`
    FOREIGN KEY (`labolatory_id`)
    REFERENCES `ClinicDB`.`labolatory` (`labolatory_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

    
INSERT INTO clinic(name)
	VALUES("Health"),
	("Wellness Bliss Group" ),
    ("Back Smart Wellness Center"),
    ("Elite Wellness Collective"),
    ("Trinity Health and Wellness Medical Group");
    
INSERT INTO analysis_type(type)
	VALUES("x-ray"),
	("fluorography"),
    ("UZI"),
    ("tomograms");
    
INSERT INTO labolatory(labolatory_id, labolatory_number, clinic_id, analysis_type_id)
	VALUES(1,	5,	1,	1),
	(2, 25,	3,	2 ),
    (3, 31,	2,	2),
    (4, 56,	2,	1),
    (5, 115, 2, 3),
    (6, 205, 5,	4);
INSERT INTO doctor(doctor_id, name, surname, clinic_name)
	VALUES(1,	"Petro",	"Petrenko",	"Health"),
	(2, "Ivan",	"Rosh",	"Trinity Health and Wellness Medical Group"),
    (3, "Bogdan",	"Gid",	"Health"),
    (4, "Yuriy",	"Rasid",	"Wellness Bliss Group"),
    (5, "Roman",	"Porak",	"Back Smart Wellness Center"),
    (6, "Vasyl",	"Baran",	"Trinity Health and Wellness Medical Group"),
    (7, "Vitaliy",	"Roshi",	"Elite Wellness Collective");
    
INSERT INTO patient(patient_ssn, name, surname, doctor_id)   
    VALUES(1, "Mark",	"Petrenko",	1),
    (2,"Dima",	"maik",	2),
    (3,"Roman",	"Sir",	1),
    (4,"Petro",	"Seaver",	4),
    (5,"Vital",	"Etude",	5),
    (6,"Andriy",	"Baggan",	6),
    (7,"Markian",	"Dashi",	7);


    