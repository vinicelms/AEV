-- Criação do banco para o projeto do PIM do 4º Semestre - AEV

CREATE DATABASE PIMAEV;
USE PIMAEV;

-- Criação de usuário para interagir com banco

CREATE USER 'dbinterator'@'localhost' IDENTIFIED BY 'dbit@aevpim';
GRANT ALL ON PIMAEV.* TO 'dbinterator'@'localhost';

-- Usuários (Funcionários + Cliente)

CREATE TABLE Setor
(
	id_setor				INT				NOT NULL	AUTO_INCREMENT,
    nome_setor				VARCHAR(20)		NOT NULL	UNIQUE,
    PRIMARY KEY (id_setor)
);

CREATE TABLE Cargo
(
	id_cargo				INT				NOT NULL	AUTO_INCREMENT,
	nome_cargo				VARCHAR(20)		NOT NULL	UNIQUE,
    PRIMARY KEY (id_cargo)
);

CREATE TABLE Gerente
(
	id_gerente				INT				NOT NULL	AUTO_INCREMENT,
    nome					VARCHAR(50)		NOT NULL	UNIQUE,
    id_setor				INT				NOT NULL,
    PRIMARY KEY (id_gerente),
    FOREIGN KEY (id_setor) REFERENCES Setor (id_setor)
);

CREATE TABLE Funcionario
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
    FOREIGN KEY (id_gerente) REFERENCES Gerente (id_gerente),
    FOREIGN KEY (id_cargo) REFERENCES Cargo (id_cargo)
);

CREATE TABLE FuncaoUsuario
(
	id_funcao					INT				NOT NULL	AUTO_INCREMENT,
    nome_funcao					VARCHAR(50)		NOT NULL	UNIQUE, -- Define o cargo do usuário, mesmo que ele não seja um funcionário
    PRIMARY KEY (id_funcao)
);

CREATE TABLE StatusUsuario
(
	id_status					INT				NOT NULL	AUTO_INCREMENT,
    usu_status					VARCHAR(10)		NOT NULL	UNIQUE,
    PRIMARY KEY (id_status)
);

INSERT INTO StatusUsuario (usu_status) VALUES ('Inativo');
INSERT INTO StatusUsuario (usu_status) VALUES ('Ativo');
INSERT INTO StatusUsuario (usu_status) VALUES ('Desativado');

CREATE TABLE Usuario
(
	id_usuario					INT				NOT NULL	AUTO_INCREMENT,
    usu_login					INT				NOT NULL	UNIQUE,
    usu_senha					VARCHAR(128)	NOT NULL,
    usu_nome					VARCHAR(50)		NOT NULL,
    e_funcionario				BIT				NOT NULL, -- Identifica com True ou False se ele é funcionario
    id_funcao					INT				NOT NULL,
    id_status					INT				NOT NULL,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_funcao) REFERENCES FuncaoUsuario (id_funcao),
    FOREIGN KEY (id_status) REFERENCES StatusUsuario (id_status)
);

CREATE TABLE Cliente
(
	id_cliente				INT				NOT NULL	AUTO_INCREMENT,
    nome_cliente			VARCHAR(50)		NOT NULL,
    cpf_cliente				BIGINT(11)		NOT NULL,
    sexo_cliente			CHAR			NOT NULL,
    PRIMARY KEY (id_cliente)
);

-- Produtos (Produto + Estoque)

CREATE TABLE TipoProduto
(
	id_tipo_produto			INT				NOT NULL	AUTO_INCREMENT,
    tipo_produto			VARCHAR(20)		NOT NULL	UNIQUE, -- Valores como: Sapato Social, Sandália, Bota, Tênis... e outros
    PRIMARY KEY (id_tipo_produto)
);

CREATE TABLE Produto
(
	id_produto				INT				NOT NULL	AUTO_INCREMENT,
    nome_produto			VARCHAR(50)		NOT NULL,
    marca_produto			VARCHAR(40)		NOT NULL,
    cor_produto				VARCHAR(25)		NOT NULL,
    descricao_produto		VARCHAR(500)	NULL,
    tamanho_produto			INT				NOT NULL,
    id_tipo_produto			INT				NOT NULL,
    qtd_minima				INT				NOT NULL,
    qtd_estoque				INT				NOT NULL,
    valor_compra			DECIMAL(5,2)	NOT NULL,
    valor_venda				DECIMAL(5,2)	NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_tipo_produto) REFERENCES TipoProduto (id_tipo_produto)
);

CREATE TABLE Armazenagem
(
	produto_prateleira		INT				NOT NULL,
    prateleiras				INT				NOT NULL,
    estantes				INT				NOT NULL,
    ativo					BIT				NOT NULL
);

-- Compra e Venda de produtos

CREATE TABLE Pagamento
(
	id_pagamento			INT				NOT NULL	AUTO_INCREMENT,
    tipo_pagamento			VARCHAR(30)		NOT NULL	UNIQUE, -- Valores como: Cartão Débito, Cartão Crédito e Dinheiro
    PRIMARY KEY (id_pagamento)
);

CREATE TABLE NotaFiscal
(
	id_nota_fiscal			INT				NOT NULL	AUTO_INCREMENT,
    matricula_func			INT				NOT NULL,
    valor_nota				DECIMAL(7,2)	NOT NULL,
    tipo_movimentacao		CHAR(1)			NOT NULL, -- C para compra; V para venda
    data_vencimento			DATETIME		NOT NULL,
    data_pagamento			DATETIME		NULL,
    id_pagamento			INT				NOT NULL,
    nota_paga				BIT				NOT NULL,
    PRIMARY KEY (id_nota_fiscal),
    FOREIGN KEY (matricula_func) REFERENCES Funcionario (matricula),
    FOREIGN KEY (id_pagamento) REFERENCES Pagamento (id_pagamento)
);

CREATE TABLE Venda
(
	id_venda				INT				NOT NULL	AUTO_INCREMENT,
    id_produto				INT				NOT NULL,
    valor_produto			DECIMAL(7,2)	NOT NULL,
    qtd_produto				INT				NOT NULL,
    id_nota_fiscal			INT				NOT NULL,
    PRIMARY KEY (id_venda),
    FOREIGN KEY (id_produto) REFERENCES Produto (id_produto),
    FOREIGN KEY (id_nota_fiscal) REFERENCES NotaFiscal (id_nota_fiscal)
);

CREATE TABLE Compra
(
	id_compra				INT				NOT NULL	AUTO_INCREMENT,
    id_produto				INT				NOT NULL,
    valor_produto			DECIMAL(7,2)	NOT NULL,
    qtd_produto				INT				NOT NULL,
    id_nota_fiscal			INT				NOT NULL,
    PRIMARY KEY (id_compra),
    FOREIGN KEY (id_produto) REFERENCES Produto (id_produto),
    FOREIGN KEY (id_nota_fiscal) REFERENCES NotaFiscal (id_nota_fiscal)
);

-- Controle de caixa

CREATE TABLE Caixa
(
	id_caixa				INT				NOT NULL	AUTO_INCREMENT,
    data_caixa				DATETIME		NOT NULL,
    valor_caixa				DECIMAL(12,2)	NOT NULL,
    soma_estoque			DECIMAL(12,2)	NOT NULL,
    soma_vendas				DECIMAL(8,2)	NOT NULL,
    soma_compra				DECIMAL(8,2)	NOT NULL,
    PRIMARY KEY (id_caixa)
);

CREATE TABLE BalancoFinanceiro
(
	id_auditoria			INT				NOT NULL	AUTO_INCREMENT,
    matricula_func			INT				NOT NULL,
    data_auditoria			DATETIME		NOT NULL,
    data_ini_auditoria		DATE			NOT NULL,
    data_term_auditoria		DATE			NOT NULL,
    valor_entrada			DECIMAL(11,2)	NOT NULL,
    valor_saida				DECIMAL(11,2)	NOT NULL,
    auditoria_ok			BIT				NOT NULL, -- Define se a auditoria teve problemas, como por exemplo alguma nota errada
    PRIMARY KEY (id_auditoria),
    FOREIGN KEY (matricula_func) REFERENCES Funcionario (matricula)
);

CREATE TABLE log
(
	id_log					INT				NOT NULL,
    matricula_func			INT				NOT NULL,
    descricao_log			INT				NOT NULL,
    data_log				DATETIME		NOT NULL,
    PRIMARY KEY (id_log),
    FOREIGN KEY (matricula_func) REFERENCES Funcionario (matricula)
);