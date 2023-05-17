-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobdb` ;

-- -----------------------------------------------------
-- Schema jobdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobdb` DEFAULT CHARACTER SET utf8 ;
USE `jobdb` ;

-- -----------------------------------------------------
-- Table `Company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Company` ;

CREATE TABLE IF NOT EXISTS `Company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `apply_date` DATETIME NOT NULL,
  `website` VARCHAR(45) NULL,
  `active` TINYINT NOT NULL,
  `remote` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Contact` ;

CREATE TABLE IF NOT EXISTS `Contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `Company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contact_Company_idx` (`Company_id` ASC),
  CONSTRAINT `fk_Contact_Company`
    FOREIGN KEY (`Company_id`)
    REFERENCES `Company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Category` ;

CREATE TABLE IF NOT EXISTS `Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Question` ;

CREATE TABLE IF NOT EXISTS `Question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question_asked` VARCHAR(45) NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Question_Category1_idx` (`Category_id` ASC),
  CONSTRAINT `fk_Question_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `Category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Company_has_Question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Company_has_Question` ;

CREATE TABLE IF NOT EXISTS `Company_has_Question` (
  `Company_id` INT NOT NULL,
  `Question_id` INT NOT NULL,
  PRIMARY KEY (`Company_id`, `Question_id`),
  INDEX `fk_Company_has_Question_Question1_idx` (`Question_id` ASC),
  INDEX `fk_Company_has_Question_Company1_idx` (`Company_id` ASC),
  CONSTRAINT `fk_Company_has_Question_Company1`
    FOREIGN KEY (`Company_id`)
    REFERENCES `Company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Company_has_Question_Question1`
    FOREIGN KEY (`Question_id`)
    REFERENCES `Question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

CREATE TABLE IF NOT EXISTS `User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `photo` VARCHAR(2000) NULL,
  `create_date` DATETIME NULL,
  `enabled` TINYINT NULL,
  `password` VARCHAR(200) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Offer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Offer` ;

CREATE TABLE IF NOT EXISTS `Offer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Salary` DOUBLE NULL,
  `health` VARCHAR(45) NULL,
  `dental` VARCHAR(45) NULL,
  `overtime` VARCHAR(45) NULL,
  `holidays` VARCHAR(45) NULL,
  `User_id` INT NOT NULL,
  `Company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Offer_User1_idx` (`User_id` ASC),
  INDEX `fk_Offer_Company1_idx` (`Company_id` ASC),
  CONSTRAINT `fk_Offer_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Offer_Company1`
    FOREIGN KEY (`Company_id`)
    REFERENCES `Company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User_has_Company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User_has_Company` ;

CREATE TABLE IF NOT EXISTS `User_has_Company` (
  `User_id` INT NOT NULL,
  `Company_id` INT NOT NULL,
  PRIMARY KEY (`User_id`, `Company_id`),
  INDEX `fk_User_has_Company_Company1_idx` (`Company_id` ASC),
  INDEX `fk_User_has_Company_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_User_has_Company_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Company_Company1`
    FOREIGN KEY (`Company_id`)
    REFERENCES `Company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User_has_Question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User_has_Question` ;

CREATE TABLE IF NOT EXISTS `User_has_Question` (
  `User_id` INT NOT NULL,
  `Question_id` INT NOT NULL,
  PRIMARY KEY (`User_id`, `Question_id`),
  INDEX `fk_User_has_Question_Question1_idx` (`Question_id` ASC),
  INDEX `fk_User_has_Question_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_User_has_Question_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Question_Question1`
    FOREIGN KEY (`Question_id`)
    REFERENCES `Question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Contact_has_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Contact_has_User` ;

CREATE TABLE IF NOT EXISTS `Contact_has_User` (
  `Contact_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`Contact_id`, `User_id`),
  INDEX `fk_Contact_has_User_User1_idx` (`User_id` ASC),
  INDEX `fk_Contact_has_User_Contact1_idx` (`Contact_id` ASC),
  CONSTRAINT `fk_Contact_has_User_Contact1`
    FOREIGN KEY (`Contact_id`)
    REFERENCES `Contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_has_User_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS admin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'admin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Company`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (1, 'McDonalds', '2023-01-01', NULL, true, true);
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (2, 'Shotgun Willies Web Services', '2021-03-31', NULL, false, false);
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (3, 'Foogle', '2022-02-22', NULL, true, false);
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (4, 'Crockets Java Pro', '2023-01-20', NULL, true, true);
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (5, 'Dill Skstillery', '2023-04-29', NULL, true, true);
INSERT INTO `Company` (`id`, `name`, `apply_date`, `website`, `active`, `remote`) VALUES (6, 'Eggolo', '2023-04-28', NULL, false, true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Contact`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (1, 'Jerry', 'Main', '992-388-0184', 'Jerry@theMac.com', 'Recruiter ', 1);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (2, 'Willy', 'Williamson', '555-555-5555', 'Willy@yeehaw.com', 'Big boss man', 2);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (3, 'Wendy', 'Williamson', '555-555-5556', 'MrsWilly@yeehaw.com', 'CEO', 2);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (4, 'Ronald ', 'Donald', '992-622-8377', NULL, 'Founder', 1);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (5, 'Parry', 'Lage', '740-207-3443', 'lageP@foogle.com', NULL, 3);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (6, 'Davy', 'Crocket', NULL, 'king@gmail.com', 'King of the wild frontier ', 4);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (7, 'Bob', 'Dobbs', NULL, 'bob@skd.com', 'Lead Developer ', 5);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (8, 'Eric', 'Clucks', NULL, 'cluck@roost.com', 'Chicken wrangler ', 5);
INSERT INTO `Contact` (`id`, `first_name`, `last_name`, `phone`, `email`, `title`, `Company_id`) VALUES (9, 'Bergey ', 'Srin', '800-555-5235', 'bergeyS@eggolo.com', 'Founder', 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Category` (`id`, `name`) VALUES (1, 'General');
INSERT INTO `Category` (`id`, `name`) VALUES (2, 'Java Basics');
INSERT INTO `Category` (`id`, `name`) VALUES (3, 'HTML');
INSERT INTO `Category` (`id`, `name`) VALUES (4, 'JavaScript');
INSERT INTO `Category` (`id`, `name`) VALUES (5, 'OOP');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Question`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (1, 'What are the four pillars of programming ', 1);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (2, 'What is a JavaScript function', 4);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (3, 'What is an Access Modifier', 2);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (4, 'What do JavaScript Events trigger?', 4);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (5, 'Name three parts of an HTML file', 3);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (6, 'How to center a Div', 3);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (7, 'What is inheritance', 1);
INSERT INTO `Question` (`id`, `question_asked`, `Category_id`) VALUES (8, 'What is polymorphism ', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Company_has_Question`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (1, 1);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (1, 2);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (2, 5);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (3, 2);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (3, 1);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (4, 1);
INSERT INTO `Company_has_Question` (`Company_id`, `Question_id`) VALUES (4, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `User`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `User` (`id`, `first_name`, `last_name`, `username`, `photo`, `create_date`, `enabled`, `password`, `role`) VALUES (1, 'David', 'Dunlevy', 'ekoostik', NULL, NULL, true, '$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS', 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Offer`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Offer` (`id`, `Salary`, `health`, `dental`, `overtime`, `holidays`, `User_id`, `Company_id`) VALUES (1, 50000, 'Full', 'Partial', 'double time', '6', 1, 1);
INSERT INTO `Offer` (`id`, `Salary`, `health`, `dental`, `overtime`, `holidays`, `User_id`, `Company_id`) VALUES (2, 100000, 'Full', 'Full', '', '10', 1, 2);
INSERT INTO `Offer` (`id`, `Salary`, `health`, `dental`, `overtime`, `holidays`, `User_id`, `Company_id`) VALUES (3, 75000, 'Full', NULL, 'double time', '10', 1, 3);
INSERT INTO `Offer` (`id`, `Salary`, `health`, `dental`, `overtime`, `holidays`, `User_id`, `Company_id`) VALUES (4, 65000, 'Full', NULL, 'double time', '5', 1, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `User_has_Company`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 1);
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 2);
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 3);
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 4);
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 5);
INSERT INTO `User_has_Company` (`User_id`, `Company_id`) VALUES (1, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `User_has_Question`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `User_has_Question` (`User_id`, `Question_id`) VALUES (1, 2);
INSERT INTO `User_has_Question` (`User_id`, `Question_id`) VALUES (1, 4);
INSERT INTO `User_has_Question` (`User_id`, `Question_id`) VALUES (1, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Contact_has_User`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (1, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (2, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (3, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (4, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (5, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (6, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (7, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (8, 1);
INSERT INTO `Contact_has_User` (`Contact_id`, `User_id`) VALUES (9, 1);

COMMIT;

