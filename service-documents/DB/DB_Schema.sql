-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema vns
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vns
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vns` DEFAULT CHARACTER SET latin1 ;
USE `vns` ;

-- -----------------------------------------------------
-- Table `vns`.`cap`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`cap` ;

CREATE TABLE IF NOT EXISTS `vns`.`cap` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `MOBILE` VARCHAR(45) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vns`.`trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`trip` ;

CREATE TABLE IF NOT EXISTS `vns`.`trip` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `FromPlace` VARCHAR(45) NULL DEFAULT NULL,
  `ToPlace` VARCHAR(45) NULL DEFAULT NULL,
  `FromTime` DATETIME NULL DEFAULT NULL,
  `ToTime` DATETIME NULL DEFAULT NULL,
  `CapId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ID_idx` (`CapId` ASC),
  INDEX `CID_idx` (`CapId` ASC),
  CONSTRAINT `C_ID`
    FOREIGN KEY (`CapId`)
    REFERENCES `vns`.`cap` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vns`.`notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`notes` ;

CREATE TABLE IF NOT EXISTS `vns`.`notes` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Note` VARCHAR(45) NULL DEFAULT NULL,
  `TimeStamp` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `TripId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ID_idx` (`TripId` ASC),
  CONSTRAINT `ID`
    FOREIGN KEY (`TripId`)
    REFERENCES `vns`.`trip` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vns`.`rider`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`rider` ;

CREATE TABLE IF NOT EXISTS `vns`.`rider` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL DEFAULT NULL,
  `MOBILE` VARCHAR(45) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vns`.`rider_trips`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`rider_trips` ;

CREATE TABLE IF NOT EXISTS `vns`.`rider_trips` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `RiderId` INT(11) NULL DEFAULT NULL,
  `TripId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `R_ID_idx` (`RiderId` ASC),
  INDEX `T_ID_idx` (`TripId` ASC),
  CONSTRAINT `R_ID`
    FOREIGN KEY (`RiderId`)
    REFERENCES `vns`.`rider` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `T_ID`
    FOREIGN KEY (`TripId`)
    REFERENCES `vns`.`trip` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vns`.`rider_notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vns`.`rider_notes` ;

CREATE TABLE IF NOT EXISTS `vns`.`rider_notes` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Rider_Trip_Id` INT(11) NOT NULL,
  `NoteId` INT(11) NOT NULL,
  `NoteStatus` INT(11) NULL DEFAULT '0',
  `TripId` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ID_idx` (`Rider_Trip_Id` ASC),
  INDEX `ID_idx1` (`NoteId` ASC),
  INDEX `T_ID_idx` (`TripId` ASC),
  INDEX `Trip_Id_idx` (`TripId` ASC),
  CONSTRAINT `N_ID`
    FOREIGN KEY (`NoteId`)
    REFERENCES `vns`.`notes` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `RD_ID`
    FOREIGN KEY (`Rider_Trip_Id`)
    REFERENCES `vns`.`rider_trips` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Trip_Id`
    FOREIGN KEY (`TripId`)
    REFERENCES `vns`.`trip` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
