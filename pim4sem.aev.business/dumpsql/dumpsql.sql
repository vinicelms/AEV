-- Criação do banco para o projeto do PIM do 4º Semestre - AEV

CREATE DATABASE pimaev;

USE pimaev;

-- Usuários (Funcionários + Cliente)

CREATE TABLE setor
(
	id_setor				INT				NOT NULL	AUTO_INCREMENT,
    nome_setor				VARCHAR(20)		NOT NULL,
    PRIMARY KEY (id_setor)
);

CREATE TABLE cargo
(
	id_cartgo				INT				NOT NULL	AUTO_INCREMENT,
	nome_cargo				VARCHAR(20)		NOT NULL,
    PRIMARY KEY (id_cargo)
);

CREATE TABLE gerente
(
	id_gerente				INT				NOT NULL	AUTO_INCREMENT,
    nome					VARCHAR(50)		NOT NULL,
    id_setor				INT				NOT NULL,
    PRIMARY KEY (id_gerente),
    FOREIGN KEY (id_setor) REFERENCES setor (id_setor)
);

CREATE TABLE funcionario
(
	matricula				INT				NOT NULL,
    nome_func				VARCHAR(50)		NOT NULL,
    sexo_func				CHAR(1)			NOT NULL, -- pode ser M ou F
    id_cargo				INT				NOT NULL,
    id_setor				INT				NOT NULL,
    salario					DECIMAL(7,2)	NOT NULL, -- valor máximo: 99.999,99
    id_gerente				INT				NOT NULL,
    cargo_gerencial			BIT				NOT NULL,
    ano_nascimento			DATE			NOT NULL,
    ano_contratacao			DATETIME		NOT NULL,
    PRIMARY KEY (matricula),
    FOREIGN KEY (id_gerente) REFERENCES gerente (id_gerente),
    FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo)
);

CREATE TABLE cliente
(
	id_cliente				INT				NOT NULL	AUTO_INCREMENT,
    nome_cliente			VARCHAR(50)		NOT NULL,
    cpf_cliente				BIGINT(11)		NOT NULL,
    sexo_cliente			CHAR			NOT NULL,
    PRIMARY KEY (id_cliente)
);

-- Produtos (Produto + Estoque)

CREATE TABLE tipoProduto
(
	id_tipo_produto			INT				NOT NULL	AUTO_INCREMENT,
    tipo_produto			VARCHAR(20)		NOT NULL, -- Valores como: Sapato Social, Sandália, Bota, Tênis... e outros
    PRIMARY KEY (id_tipo_produto)
);

CREATE TABLE produto
(
	id_produto				INT				NOT NULL	AUTO_INCREMENT,
    nome_produto			VARCHAR(20)		NOT NULL,
    marca_produto			VARCHAR(10)		NOT NULL,
    cor_produto				VARCHAR(10)		NOT NULL,
    descricao_produto		VARCHAR(200)	NULL,
    tamanho_produto			INT				NOT NULL,
    id_tipo_produto			INT				NOT NULL,
    qtd_minima				INT				NOT NULL,
    qtd_estoque				INT				NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_tipo_produto) REFERENCES tipoProduto (id_tipo_produto)
);

CREATE TABLE notaFiscal
(
	id_nota_fiscal			INT				NOT NULL	AUTO_INCREMENT,
    id_funcionario			INT				NOT NULL,
    valor_nota				INT				NOT NULL,
    PRIMARY KEY (id_nota_fiscal)
);

CREATE TABLE venda
(
	id_venda				INT				NOT NULL	AUTO_INCREMENT,
    id_produto				INT				NOT NULL,
    valor_produto			DECIMAL(4,2)	NOT NULL,
    qtd_produto				INT				NOT NULL,
    PRIMARY KEY (id_venda),
    FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

CREATE TABLE compra
(
	id_compra				INT				NOT NULL	AUTO_INCREMENT,
    id_produto				INT				NOT NULL,
    valor_produto			INT				NOT NULL,
    qtd_produto				INT				NOT NULL
);