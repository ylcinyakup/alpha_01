-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema testspringdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `testspringdb` ;

-- -----------------------------------------------------
-- Schema testspringdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testspringdb` DEFAULT CHARACTER SET utf8 ;
USE `testspringdb` ;

-- -----------------------------------------------------
-- Table `testspringdb`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testspringdb`.`users` ;

CREATE TABLE IF NOT EXISTS `testspringdb`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `balance` INT(11) NULL DEFAULT NULL,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testspringdb`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testspringdb`.`address` ;

CREATE TABLE IF NOT EXISTS `testspringdb`.`address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `neighborhood` VARCHAR(45) NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `building` VARCHAR(45) NULL DEFAULT NULL,
  `door` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_users_idx` (`username` ASC),
  CONSTRAINT `fk_address_users`
    FOREIGN KEY (`username`)
    REFERENCES `testspringdb`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
