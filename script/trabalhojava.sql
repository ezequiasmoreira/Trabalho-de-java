-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 04-Out-2018 às 15:51
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trabalhojava`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `dataNascimento` date NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cidade` (`id_cidade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cidade` (`id_cidade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cidade` (`id_cidade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_venda`
--

DROP TABLE IF EXISTS `itens_venda`;
CREATE TABLE IF NOT EXISTS `itens_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_venda` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_venda` (`id_venda`),
  KEY `id_produto` (`id_produto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `peso` double(10,2) NOT NULL,
  `dataValidade` date NOT NULL,
  `precoCusto` double(10,2) NOT NULL,
  `precoVenda` double(10,2) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataEfetuada` date NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_funcionario` (`id_funcionario`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
