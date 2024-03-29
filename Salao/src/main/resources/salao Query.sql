-- MySQL Script generated by MySQL Workbench
-- 11/08/16 07:20:29
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Salao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Salao` ;

-- -----------------------------------------------------
-- Schema Salao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Salao` DEFAULT CHARACTER SET utf8 ;
USE `Salao` ;

-- -----------------------------------------------------
-- Table `Salao`.`Cadastro_Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Cadastro_Cliente` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Cadastro_Cliente` (
  `id_Cliente` INT NOT NULL AUTO_INCREMENT,
  `cpf_Cliente` VARCHAR(14) NOT NULL,
  `rg_Cliente` INT(10) NULL,
  `nome_Cliente` VARCHAR(45) NOT NULL,
  `dt_Nascimento_Cliente` VARCHAR(11) NULL,
  `pai_Cliente` VARCHAR(50) NULL,
  `mae_Cliente` VARCHAR(50) NULL,
  `sexo_Cliente` CHAR(1) NULL,
  `bairro_Cliente` VARCHAR(100) NULL,
  `cidade_Cliente` VARCHAR(100) NULL,
  `cep_Cliente` VARCHAR(100) NULL,
  `rua_Cliente` VARCHAR(100) NULL,
  `numero_Cliente` INT(6) NULL,
  `email_Cliente` VARCHAR(200) NULL,
  `telefone_Cliente` VARCHAR(14) NULL,
  `uf_Cliente` VARCHAR(2) NULL,
  PRIMARY KEY (`id_Cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Cadastro_Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Cadastro_Funcionario` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Cadastro_Funcionario` (
  `id_Funcionario` INT NOT NULL AUTO_INCREMENT,
  `comissao_Servico` INT(2) NULL,
  `comissao_Venda` INT(2) NULL,
  `cpf_Funcionario` VARCHAR(14) NOT NULL,
  `nome_Mae` VARCHAR(50) NULL,
  `nome_pai` VARCHAR(50) NULL,
  `nome_Funcionario` VARCHAR(50) NOT NULL,
  `dt_Nacimento_Funcionario` DATE NOT NULL,
  `salario_Funcionario` DECIMAL(10,2) NOT NULL,
  `rg_Funcionario` INT(10) NULL,
  `bairro_Funcionario` VARCHAR(100) NULL,
  `cidade__Funcionario` VARCHAR(100) NULL,
  `cep_Funcionario` VARCHAR(100) NULL,
  `rua_Funcionario` VARCHAR(100) NULL,
  `numero_Funcionario` INT(6) NULL,
  `email_Funcionario` VARCHAR(200) NULL,
  `telefone_Funcionario` VARCHAR(14) NULL,
  `uf_Funcionario` VARCHAR(2) NULL,
  `sexo_Funcionario` CHAR NULL,
  PRIMARY KEY (`id_Funcionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Cadastro_Servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Cadastro_Servico` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Cadastro_Servico` (
  `id_Servico` INT NOT NULL AUTO_INCREMENT,
  `nome_Servico` VARCHAR(45) NOT NULL,
  `duracao_Servico` TIMESTAMP NOT NULL,
  `valor_Servico` DECIMAL(10,2) NOT NULL,
  `valor_Referencia` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_Servico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Cadastro_Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Cadastro_Produto` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Cadastro_Produto` (
  `id_Produto` INT NOT NULL AUTO_INCREMENT,
  `nome_Produto` VARCHAR(45) NOT NULL,
  `descricao_Produto` VARCHAR(250) NULL,
  `qtd_Produto` INT NULL,
  `valor_produto` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_Produto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Cadastro_Fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Cadastro_Fornecedor` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Cadastro_Fornecedor` (
  `id_Fornecedor` INT NOT NULL,
  `cnpj_Fornecedor` VARCHAR(18) NOT NULL,
  `nome_Fornecedor` VARCHAR(45) NOT NULL,
  `nome_Empresa` VARCHAR(45) NOT NULL,
  `bairro_Fornecedor` VARCHAR(100) NULL,
  `cidade_Fornecedor` VARCHAR(100) NULL,
  `cep__Fornecedor` VARCHAR(100) NULL,
  `rua_Fornecedor` VARCHAR(100) NULL,
  `numero_Fornecedor` INT(6) NULL,
  `email_Fornecedor` VARCHAR(200) NULL,
  `telefone_Fornecedor` VARCHAR(14) NULL,
  `uf_Fornecedor` VARCHAR(2) NULL,
  PRIMARY KEY (`id_Fornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`venda_Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`venda_Produto` ;

CREATE TABLE IF NOT EXISTS `Salao`.`venda_Produto` (
  `id_venda_Produto` INT NOT NULL,
  `forma_Pagamente` CHAR NOT NULL,
  `data_Venda` DATE NOT NULL,
  `Valor_Venda` VARCHAR(45) NULL,
  `Cadastro_Funcionario_id_Funcionario` INT NOT NULL,
  `Cadastro_Cliente_id_Cliente` INT NOT NULL,
  PRIMARY KEY (`id_venda_Produto`),
  INDEX `fk_venda_Produto_Cadastro_Funcionario1_idx` (`Cadastro_Funcionario_id_Funcionario` ASC),
  INDEX `fk_venda_Produto_Cadastro_Cliente1_idx` (`Cadastro_Cliente_id_Cliente` ASC),
  CONSTRAINT `fk_venda_Produto_Cadastro_Funcionario1`
    FOREIGN KEY (`Cadastro_Funcionario_id_Funcionario`)
    REFERENCES `Salao`.`Cadastro_Funcionario` (`id_Funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_Produto_Cadastro_Cliente1`
    FOREIGN KEY (`Cadastro_Cliente_id_Cliente`)
    REFERENCES `Salao`.`Cadastro_Cliente` (`id_Cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Prestamento_Servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Prestamento_Servico` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Prestamento_Servico` (
  `id_Prestamento_Servico` INT NOT NULL,
  `data_marcada` DATE NULL,
  `duracao` TIMESTAMP NULL,
  `hora` DATETIME NULL,
  `executado_Servico` TINYINT(1) NULL,
  `Cadastro_Funcionario_id_Funcionario` INT NOT NULL,
  `Cadastro_Cliente_id_Cliente` INT NOT NULL,
  PRIMARY KEY (`id_Prestamento_Servico`),
  INDEX `fk_Prestamento_Servico_Cadastro_Funcionario1_idx` (`Cadastro_Funcionario_id_Funcionario` ASC),
  INDEX `fk_Prestamento_Servico_Cadastro_Cliente1_idx` (`Cadastro_Cliente_id_Cliente` ASC),
  CONSTRAINT `fk_Prestamento_Servico_Cadastro_Funcionario1`
    FOREIGN KEY (`Cadastro_Funcionario_id_Funcionario`)
    REFERENCES `Salao`.`Cadastro_Funcionario` (`id_Funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestamento_Servico_Cadastro_Cliente1`
    FOREIGN KEY (`Cadastro_Cliente_id_Cliente`)
    REFERENCES `Salao`.`Cadastro_Cliente` (`id_Cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Itens_Servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Itens_Servico` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Itens_Servico` (
  `id_Itens_Servico` INT NOT NULL AUTO_INCREMENT,
  `Cadastro_Servico_id_Servico` INT NOT NULL,
  `Horario_id_Horario` INT NOT NULL,
  PRIMARY KEY (`id_Itens_Servico`),
  INDEX `fk_Itens_Servico_Cadastro_Servico1_idx` (`Cadastro_Servico_id_Servico` ASC),
  INDEX `fk_Itens_Servico_Horario1_idx` (`Horario_id_Horario` ASC),
  CONSTRAINT `fk_Itens_Servico_Cadastro_Servico1`
    FOREIGN KEY (`Cadastro_Servico_id_Servico`)
    REFERENCES `Salao`.`Cadastro_Servico` (`id_Servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Servico_Horario1`
    FOREIGN KEY (`Horario_id_Horario`)
    REFERENCES `Salao`.`Prestamento_Servico` (`id_Prestamento_Servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Estoque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Estoque` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Estoque` (
  `id_Estoque` INT NOT NULL,
  `qtd_Estoque` INT NOT NULL,
  `estoque_min` INT NOT NULL,
  `valor_Produto` DECIMAL(10,2) NOT NULL,
  `qtd_Estoque_Atualizado` INT NOT NULL,
  `id_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Estoque`),
  INDEX `fk_Estoque_Cadastro_Produto1_idx` (`id_Produto` ASC),
  CONSTRAINT `fk_Estoque_Cadastro_Produto1`
    FOREIGN KEY (`id_Produto`)
    REFERENCES `Salao`.`Cadastro_Produto` (`id_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Entrada_Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Entrada_Produto` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Entrada_Produto` (
  `id_Entrada_Produto` INT NOT NULL AUTO_INCREMENT,
  `estoque` INT NOT NULL,
  `data_Entrada` DATE NOT NULL,
  `Estoque_id_Estoque` INT NOT NULL,
  PRIMARY KEY (`id_Entrada_Produto`),
  INDEX `fk_Entrada_Produto_Estoque1_idx` (`Estoque_id_Estoque` ASC),
  CONSTRAINT `fk_Entrada_Produto_Estoque1`
    FOREIGN KEY (`Estoque_id_Estoque`)
    REFERENCES `Salao`.`Estoque` (`id_Estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Itens_Fornecimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Itens_Fornecimento` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Itens_Fornecimento` (
  `id_Itens_Fornecimento` INT NOT NULL,
  `qtd_Produto_Fornecido` INT NOT NULL,
  `id_Fornecedor` INT NOT NULL,
  `id_Entrada_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Itens_Fornecimento`),
  INDEX `fk_Itens_Fornecimento_Cadastro_Fornecedor1_idx` (`id_Fornecedor` ASC),
  INDEX `fk_Itens_Fornecimento_Entrada_Produto1_idx` (`id_Entrada_Produto` ASC),
  CONSTRAINT `fk_Itens_Fornecimento_Cadastro_Fornecedor1`
    FOREIGN KEY (`id_Fornecedor`)
    REFERENCES `Salao`.`Cadastro_Fornecedor` (`id_Fornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Fornecimento_Entrada_Produto1`
    FOREIGN KEY (`id_Entrada_Produto`)
    REFERENCES `Salao`.`Entrada_Produto` (`id_Entrada_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Pagamento_Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Pagamento_Funcionario` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Pagamento_Funcionario` (
  `id_Pagamento_Funcionario` INT NOT NULL AUTO_INCREMENT,
  `data_pagamento` DATE NOT NULL,
  `valor_Pagamento` DECIMAL(10,2) NOT NULL,
  `cadastro_Funcionario_id_Funcionario` INT NOT NULL,
  PRIMARY KEY (`id_Pagamento_Funcionario`),
  INDEX `fk_Pagamento_Funcionario_cadastro_Funcionario1_idx` (`cadastro_Funcionario_id_Funcionario` ASC),
  CONSTRAINT `fk_Pagamento_Funcionario_cadastro_Funcionario1`
    FOREIGN KEY (`cadastro_Funcionario_id_Funcionario`)
    REFERENCES `Salao`.`Cadastro_Funcionario` (`id_Funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Gastos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Gastos` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Gastos` (
  `id_Gastos` INT NOT NULL AUTO_INCREMENT,
  `valor_Gasto_Geral` DECIMAL(10,2) NOT NULL,
  `id_Entrada_Produto` INT NOT NULL,
  `id_Pagamento_Funcionario` INT NOT NULL,
  `venda_Produto_id_venda_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Gastos`),
  INDEX `fk_Gastos_Entrada_Produto1_idx` (`id_Entrada_Produto` ASC),
  INDEX `fk_Gastos_Pagamento_Funcionario1_idx` (`id_Pagamento_Funcionario` ASC),
  INDEX `fk_Gastos_venda_Produto1_idx` (`venda_Produto_id_venda_Produto` ASC),
  CONSTRAINT `fk_Gastos_Entrada_Produto1`
    FOREIGN KEY (`id_Entrada_Produto`)
    REFERENCES `Salao`.`Entrada_Produto` (`id_Entrada_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gastos_Pagamento_Funcionario1`
    FOREIGN KEY (`id_Pagamento_Funcionario`)
    REFERENCES `Salao`.`Pagamento_Funcionario` (`id_Pagamento_Funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gastos_venda_Produto1`
    FOREIGN KEY (`venda_Produto_id_venda_Produto`)
    REFERENCES `Salao`.`venda_Produto` (`id_venda_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Pagamento_Conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Pagamento_Conta` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Pagamento_Conta` (
  `id_Pagamento_Conta` INT NOT NULL AUTO_INCREMENT,
  `valor_Pagamento` DECIMAL(10,2) NOT NULL,
  `data_Pagamento` VARCHAR(45) NOT NULL,
  `Gastos_id_Gastos` INT NOT NULL,
  PRIMARY KEY (`id_Pagamento_Conta`),
  INDEX `fk_Pagamento_Conta_Gastos1_idx` (`Gastos_id_Gastos` ASC),
  CONSTRAINT `fk_Pagamento_Conta_Gastos1`
    FOREIGN KEY (`Gastos_id_Gastos`)
    REFERENCES `Salao`.`Gastos` (`id_Gastos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Itens_Venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Itens_Venda` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Itens_Venda` (
  `id_Itens_Venda` INT NOT NULL AUTO_INCREMENT,
  `qtd_Produto` INT NOT NULL,
  `venda_Produto_id_venda_Produto` INT NOT NULL,
  `Estoque_id_Estoque` INT NOT NULL,
  PRIMARY KEY (`id_Itens_Venda`),
  INDEX `fk_Itens_Venda_venda_Produto1_idx` (`venda_Produto_id_venda_Produto` ASC),
  INDEX `fk_Itens_Venda_Estoque1_idx` (`Estoque_id_Estoque` ASC),
  CONSTRAINT `fk_Itens_Venda_venda_Produto1`
    FOREIGN KEY (`venda_Produto_id_venda_Produto`)
    REFERENCES `Salao`.`venda_Produto` (`id_venda_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Venda_Estoque1`
    FOREIGN KEY (`Estoque_id_Estoque`)
    REFERENCES `Salao`.`Estoque` (`id_Estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Crediario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Crediario` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Crediario` (
  `id_Crediario` INT NOT NULL AUTO_INCREMENT,
  `juros_Crediario` INT NOT NULL,
  `data_Inicio` DATE NOT NULL,
  `valor_Crediario` DECIMAL(10,2) NOT NULL,
  `qtd_Parcelas` INT NOT NULL,
  `venda_Produto_id_venda_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Crediario`),
  INDEX `fk_Crediario_venda_Produto1_idx` (`venda_Produto_id_venda_Produto` ASC),
  CONSTRAINT `fk_Crediario_venda_Produto1`
    FOREIGN KEY (`venda_Produto_id_venda_Produto`)
    REFERENCES `Salao`.`venda_Produto` (`id_venda_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Comissao_Venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Comissao_Venda` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Comissao_Venda` (
  `id_Comissao_Funcionario` INT NOT NULL AUTO_INCREMENT,
  `data_Venda` DATE NOT NULL,
  `forma_Pagamento` CHAR NOT NULL,
  `valor_Comissao` DECIMAL(10,2) NOT NULL,
  `venda_Produto_id_venda_Produto` INT NOT NULL,
  PRIMARY KEY (`id_Comissao_Funcionario`),
  INDEX `fk_Comissao_Venda_venda_Produto1_idx` (`venda_Produto_id_venda_Produto` ASC),
  CONSTRAINT `fk_Comissao_Venda_venda_Produto1`
    FOREIGN KEY (`venda_Produto_id_venda_Produto`)
    REFERENCES `Salao`.`venda_Produto` (`id_venda_Produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Usuario` (
  `id_Usuario` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_Usuario` INT(1) NULL,
  `id_Funcionario` INT NULL,
  PRIMARY KEY (`id_Usuario`),
  INDEX `fk_Usuario_Cadastro_Funcionario1_idx` (`id_Funcionario` ASC),
  CONSTRAINT `fk_Usuario_Cadastro_Funcionario1`
    FOREIGN KEY (`id_Funcionario`)
    REFERENCES `Salao`.`Cadastro_Funcionario` (`id_Funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Produtos` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Produtos` (
  `id_Produto` INT NOT NULL AUTO_INCREMENT,
  `qtd_Produto` INT NULL,
  `id_Servico` INT NOT NULL,
  `Estoque_id_Estoque` INT NOT NULL,
  PRIMARY KEY (`id_Produto`),
  INDEX `fk_Produtos_Cadastro_Servico1_idx` (`id_Servico` ASC),
  INDEX `fk_Produtos_Estoque1_idx` (`Estoque_id_Estoque` ASC),
  CONSTRAINT `fk_Produtos_Cadastro_Servico1`
    FOREIGN KEY (`id_Servico`)
    REFERENCES `Salao`.`Cadastro_Servico` (`id_Servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Estoque1`
    FOREIGN KEY (`Estoque_id_Estoque`)
    REFERENCES `Salao`.`Estoque` (`id_Estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Itens_Deste_Servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Itens_Deste_Servico` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Itens_Deste_Servico` (
  `id_Itens_Deste_Servico` INT NOT NULL AUTO_INCREMENT,
  `nome_Produto` VARCHAR(45) NOT NULL,
  `Itens_Servico_id_Itens_Servico` INT NOT NULL,
  PRIMARY KEY (`id_Itens_Deste_Servico`),
  INDEX `fk_Itens_Deste_Servico_Itens_Servico1_idx` (`Itens_Servico_id_Itens_Servico` ASC),
  CONSTRAINT `fk_Itens_Deste_Servico_Itens_Servico1`
    FOREIGN KEY (`Itens_Servico_id_Itens_Servico`)
    REFERENCES `Salao`.`Itens_Servico` (`id_Itens_Servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Salao`.`Comissao_Servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Salao`.`Comissao_Servico` ;

CREATE TABLE IF NOT EXISTS `Salao`.`Comissao_Servico` (
  `idComissao_Servico` INT NOT NULL AUTO_INCREMENT,
  `data_Servico` DATE NULL,
  `forma_Pagamento` CHAR(1) NULL,
  `valor_Comissao` DECIMAL(10,2) NULL,
  `Venda_Servico_id_Horario` INT NOT NULL,
  PRIMARY KEY (`idComissao_Servico`),
  INDEX `fk_Comissao_Servico_Venda_Servico1_idx` (`Venda_Servico_id_Horario` ASC),
  CONSTRAINT `fk_Comissao_Servico_Venda_Servico1`
    FOREIGN KEY (`Venda_Servico_id_Horario`)
    REFERENCES `Salao`.`Prestamento_Servico` (`id_Prestamento_Servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;