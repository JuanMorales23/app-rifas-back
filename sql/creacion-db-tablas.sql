#Creación DB
CREATE DATABASE app_rifas;
#Seleccion de db
USE app_rifas;

#Creación tabla usuario
CREATE TABLE `app_rifas`.`usuarios` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `fechanacimiento` DATE NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idusuarios`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

#Creación tabla rifas
CREATE TABLE `app_rifas`.`rifas` (
  `idrifa` INT NOT NULL AUTO_INCREMENT,
  `nombrerifa` VARCHAR(45) NULL,
  `numeroganador` INT(5) NOT NULL,
  `idusuarioganador` INT NULL,
  `fechasorteo` DATE NULL,
  `boletasrestantes` INT(5) NULL,
  `vendertodas` TINYINT NOT NULL,
  `premio` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idrifa`),
  INDEX `idusuarioganador_idx` (`idusuarioganador` ASC) VISIBLE,
  CONSTRAINT `idusuarioganador`
    FOREIGN KEY (`idusuarioganador`)
    REFERENCES `app_rifas`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

#Creación tabla numeros_usuarios
CREATE TABLE `app_rifas`.`numeros_usuarios` (
  `idnumero_usuario` INT NOT NULL AUTO_INCREMENT,
  `numero` INT(5) NOT NULL,
  `idusuario` INT NOT NULL,
  `idrifa` INT NOT NULL,
  `disponible` DATE NOT NULL,
  PRIMARY KEY (`idnumero_usuario`),
  INDEX `idusuario_idx` (`idusuario` ASC) VISIBLE,
  INDEX `idrifa_idx` (`idrifa` ASC) VISIBLE,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `app_rifas`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idrifa`
    FOREIGN KEY (`idrifa`)
    REFERENCES `app_rifas`.`rifas` (`idrifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;
