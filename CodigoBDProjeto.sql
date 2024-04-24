-- -----------------------------------------------------
-- Schema Projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Projeto` DEFAULT CHARACTER SET utf8 ;
USE `Projeto` ;

-- -----------------------------------------------------
-- Table `Projeto`.`Equipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Equipe` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `Projeto`.`Treinador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Treinador` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Treinadorcol` VARCHAR(45) NULL,
  `Equipe_ID_Equipe` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Treinador_Equipe`
    FOREIGN KEY (`Equipe_ID_Equipe`)
    REFERENCES `Projeto`.`Equipe` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `Projeto`.`Pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Pokedex` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Treinador_ID_Treinador` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Pokedex_Treinador1`
    FOREIGN KEY (`Treinador_ID_Treinador`)
    REFERENCES `Projeto`.`Treinador` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `Projeto`.`Pokemano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Pokemano` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Tipo` VARCHAR(45) NULL,
  `Nivel` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `Projeto`.`Pokemano_has_Pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Pokemano_has_Pokedex` (
  `Pokemano_ID` INT NOT NULL,
  `Pokedex_ID` INT NOT NULL,
  PRIMARY KEY (`Pokemano_ID`, `Pokedex_ID`),
  CONSTRAINT `fk_Pokemano_has_Pokedex_Pokemano1`
    FOREIGN KEY (`Pokemano_ID`)
    REFERENCES `Projeto`.`Pokemano` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pokemano_has_Pokedex_Pokedex1`
    FOREIGN KEY (`Pokedex_ID`)
    REFERENCES `Projeto`.`Pokedex` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

