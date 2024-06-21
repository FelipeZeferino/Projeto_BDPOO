-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Equipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Equipe` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `mydb`.`Treinador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Treinador` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Equipe_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Treinador_Equipe1`
    FOREIGN KEY (`Equipe_ID`)
    REFERENCES `mydb`.`Equipe` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pokedex` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Treinador_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Pokedex_Treinador1`
    FOREIGN KEY (`Treinador_ID`)
    REFERENCES `mydb`.`Treinador` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Pokemano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pokemano` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Tipo` VARCHAR(45) NULL,
  `Nivel` INT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `mydb`.`Pokemano_has_Pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pokemano_has_Pokedex` (
  `Pokemano_ID` INT NOT NULL,
  `Pokedex_ID` INT NOT NULL,
  PRIMARY KEY (`Pokemano_ID`, `Pokedex_ID`),
  CONSTRAINT `fk_Pokemano_has_Pokedex_Pokemano1`
    FOREIGN KEY (`Pokemano_ID`)
    REFERENCES `mydb`.`Pokemano` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pokemano_has_Pokedex_Pokedex1`
    FOREIGN KEY (`Pokedex_ID`)
    REFERENCES `mydb`.`Pokedex` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Habilidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Habilidade` (
  `ID` INT NOT NULL,
  `Dano` INT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo_de_Dano` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `mydb`.`Pokemano_has_Habilidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pokemano_has_Habilidade` (
  `Pokemano_ID` INT NOT NULL,
  `Habilidade_ID` INT NOT NULL,
  PRIMARY KEY (`Pokemano_ID`, `Habilidade_ID`),
  CONSTRAINT `fk_Pokemano_has_Habilidade_Pokemano1`
    FOREIGN KEY (`Pokemano_ID`)
    REFERENCES `mydb`.`Pokemano` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pokemano_has_Habilidade_Habilidade1`
    FOREIGN KEY (`Habilidade_ID`)
    REFERENCES `mydb`.`Habilidade` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


insert into equipe (nome) values ('Vermelho');
insert into equipe (nome) values ('Verde');
insert into equipe (nome) values ('Azul');

insert into pokemano (nome,tipo,nivel) values ('Pokemon A', 'Tipo A', 10);
insert into pokemano (nome,tipo,nivel) values ('Pokemon B', 'Tipo B', 10);
insert into pokemano (nome,tipo,nivel) values ('Pokemon C', 'Tipo C', 10);
insert into pokemano (nome,tipo,nivel) values ('Pokemon D', 'Tipo D', 10);

select * from pokemano;
