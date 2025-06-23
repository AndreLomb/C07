-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto_guilda`;
USE `projeto_guilda`;

-- -----------------------------------------------------
-- Table `projeto_guilda`.`Guilda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_guilda`.`Guilda` (
  `id_guilda` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `poções` VARCHAR(45) NOT NULL,
  `vestimentas` VARCHAR(45) NOT NULL,
  `armas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_guilda`));


-- -----------------------------------------------------
-- Table `projeto_guilda`.`Caçador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_guilda`.`Caçador` (
  `id_guerreiro` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `rank` VARCHAR(45) NOT NULL,
  `materiais_coletados` VARCHAR(45) NOT NULL,
  `Guilda_id_guilda` INT NOT NULL,
  PRIMARY KEY (`id_guerreiro`),
  INDEX `fk_Caçador_Guilda1_idx` (`Guilda_id_guilda` ASC) VISIBLE,
  CONSTRAINT `fk_Caçador_Guilda1`
    FOREIGN KEY (`Guilda_id_guilda`)
    REFERENCES `projeto_guilda`.`Guilda` (`id_guilda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `projeto_guilda`.`Armas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_guilda`.`Armas` (
  `id_arma` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `materiais` VARCHAR(150) NOT NULL,
  `rank` VARCHAR(45) NOT NULL,
  `estado de afiação` INT NOT NULL,
  PRIMARY KEY (`id_arma`));


-- -----------------------------------------------------
-- Table `projeto_guilda`.`Caçador_has_Armas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_guilda`.`Caçador_has_Armas` (
  `Caçador_id_guerreiro` INT NOT NULL,
  `Armas_id_arma` INT NOT NULL,
  PRIMARY KEY (`Caçador_id_guerreiro`, `Armas_id_arma`),
  INDEX `fk_Caçador_has_Armas_Armas1_idx` (`Armas_id_arma` ASC) VISIBLE,
  INDEX `fk_Caçador_has_Armas_Caçador_idx` (`Caçador_id_guerreiro` ASC) VISIBLE,
  CONSTRAINT `fk_Caçador_has_Armas_Caçador`
    FOREIGN KEY (`Caçador_id_guerreiro`)
    REFERENCES `projeto_guilda`.`Caçador` (`id_guerreiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Caçador_has_Armas_Armas1`
    FOREIGN KEY (`Armas_id_arma`)
    REFERENCES `projeto_guilda`.`Armas` (`id_arma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
