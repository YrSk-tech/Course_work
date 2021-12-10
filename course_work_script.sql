SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
DROP TABLE IF EXISTS clinic;
DROP TABLE IF EXISTS analysis_type;
DROP TABLE IF EXISTS labolatory;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS analysis;
DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS technician;


CREATE TABLE IF NOT EXISTS `mydb`.`clinic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`analysis_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`labolatory` (
  `id` INT NOT NULL,
  `laboloatory_number` INT NOT NULL,
  `clinic_id` INT NOT NULL,
  `analysis_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_labolatory_clinic_idx` (`clinic_id` ASC) VISIBLE,
  INDEX `fk_labolatory_analysis_type1_idx` (`analysis_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_labolatory_clinic`
    FOREIGN KEY (`clinic_id`)
    REFERENCES `mydb`.`clinic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_labolatory_analysis_type1`
    FOREIGN KEY (`analysis_type_id`)
    REFERENCES `mydb`.`analysis_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`doctor` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `clinic_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`patient` (
  `ssn` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`ssn`),
  INDEX `fk_patient_doctor1_idx` (`doctor_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `mydb`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`analysis` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id_identify_number` INT NOT NULL,
  `labolatory_id` INT NOT NULL,
  `analysis_type_id` INT NOT NULL,
  `patient_ssn` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_analysis_labolatory1_idx` (`labolatory_id` ASC) VISIBLE,
  INDEX `fk_analysis_analysis_type1_idx` (`analysis_type_id` ASC) VISIBLE,
  INDEX `fk_analysis_patient1_idx` (`patient_ssn` ASC) VISIBLE,
  CONSTRAINT `fk_analysis_labolatory1`
    FOREIGN KEY (`labolatory_id`)
    REFERENCES `mydb`.`labolatory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_analysis_analysis_type1`
    FOREIGN KEY (`analysis_type_id`)
    REFERENCES `mydb`.`analysis_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_analysis_patient1`
    FOREIGN KEY (`patient_ssn`)
    REFERENCES `mydb`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`diagnosis` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_ssn` INT NOT NULL,
  `patient_analysis` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id`, `patient_ssn`),
  INDEX `fk_diagnosis_patient1_idx` (`patient_ssn` ASC) VISIBLE,
  CONSTRAINT `fk_diagnosis_patient1`
    FOREIGN KEY (`patient_ssn`)
    REFERENCES `mydb`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`technician` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `labolatory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_technician_labolatory1_idx` (`labolatory_id` ASC) VISIBLE,
  CONSTRAINT `fk_technician_labolatory1`
    FOREIGN KEY (`labolatory_id`)
    REFERENCES `mydb`.`labolatory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

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
    
INSERT INTO labolatory(id, laboloatory_number, clinic_id, analysis_type_id)
	VALUES(1,	5,	1,	1),
	(2, 25,	3,	2 ),
    (3, 31,	2,	2),
    (4, 56,	2,	1),
    (5, 115, 2, 3),
    (6, 205, 5,	4);
INSERT INTO doctor(id, name, surname, clinic_name)
	VALUES(1,	"Petro",	"Petrenko",	"Health"),
	(2, "Ivan",	"Rosh",	"Trinity Health and Wellness Medical Group"),
    (3, "Bogdan",	"Gid",	"Health"),
    (4, "Yuriy",	"Rasid",	"Wellness Bliss Group"),
    (5, "Roman",	"Porak",	"Back Smart Wellness Center"),
    (6, "Vasyl",	"Baran",	"Trinity Health and Wellness Medical Group"),
    (7, "Vitaliy",	"Roshi",	"Elite Wellness Collective");
    
INSERT INTO patient(ssn, name, surname, doctor_id)   
    VALUES(1, "Mark",	"Petrenko",	1),
    (2,"Dima",	"maik",	2),
    (3,"Roman",	"Sir",	1),
    (4,"Petro",	"Seaver",	4),
    (5,"Vital",	"Etude",	5),
    (6,"Andriy",	"Baggan",	6),
    (7,"Markian",	"Dashi",	7);

    

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
