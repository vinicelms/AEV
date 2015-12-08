INSERT INTO TipoProduto (tipo_produto) VALUES ('Tênis');
INSERT INTO TipoProduto (tipo_produto) VALUES ('Sapato');
INSERT INTO TipoProduto (tipo_produto) VALUES ('Bota');
INSERT INTO TipoProduto (tipo_produto) VALUES ('Chuteira');

INSERT INTO Produto
(
	nome_produto,
    marca_produto,
    cor_produto,
    descricao_produto,
    tamanho_produto,
    id_tipo_produto,
    qtd_minima,
    qtd_estoque,
	valor_compra,
    valor_venda
) VALUES 
(
	'Nike Shox Deliver',
    'Nike',
    'Preto',
    'O Tênis Nike Shox Deliver, além de muito estiloso, é confortável. Com o sistema de amortecimento Shox, 
    proporciona absorção de choques e pisadas macias.',
	40,
    1,
    10,
    10,
    640.00,
    700.00
);

INSERT INTO Produto
(
	nome_produto,
    marca_produto,
    cor_produto,
    descricao_produto,
    tamanho_produto,
    id_tipo_produto,
    qtd_minima,
    qtd_estoque,
	valor_compra,
    valor_venda
) VALUES
(
	'Adidas Ace 15',
    'Adidas',
    'Amarelo com Preto',
    'Ace, a nova linha de chuteiras da Adidas, oferece aos boleiros muito mais controle e toque de bola. 
    Garanta a sua Chuteira Adidas Ace 15 3 FG Campo e brilhe nos gramados como os seus craques.',
    43,
    4,
    10,
    10,
    259.00,
    380.00
);

INSERT INTO Produto
(
	nome_produto,
    marca_produto,
    cor_produto,
    descricao_produto,
    tamanho_produto,
    id_tipo_produto,
    qtd_minima,
    qtd_estoque,
	valor_compra,
    valor_venda
) VALUES
(
	'Nike The Overplay 8',
    'Nike',
    'Cinza com Vermelho',
    'O Tênis Nike The Overplay 8 é desenvolvido para suprir as necessidades dos basqueteiros. 
    O calçado oferece amortecimento e conforto, além de um design moderno para o dia a dia.',
    42,
    1,
    10,
    20,
    149.00,
    180.00
);

INSERT INTO Cargo (nome_cargo) VALUES ('Vendedor');
INSERT INTO Cargo (nome_cargo) VALUES ('Gerente de Vendas');
INSERT INTO Setor (nome_setor) VALUES ('Vendas');

INSERT INTO Funcionario
(
	matricula,
    nome_func,
    sexo_func,
    id_cargo,
    id_setor,
    salario,
    cargo_gerencial,
    ano_nascimento,
    ano_contratacao
) VALUES
(
	121314,
    'José da Silva',
    'M',
    1,
    1,
    1500.00,
    false,
    '1990-12-08',
    '2015-12-08 00:00:00'
);

INSERT INTO Pagamento (tipo_pagamento) VALUES ('Dinheiro');
INSERT INTO Pagamento (tipo_pagamento) VALUES ('Cartão Débito');

INSERT INTO NotaFiscal
(
	matricula_func,
    valor_nota,
    tipo_movimentacao,
    data_vencimento,
    data_pagamento,
    id_pagamento,
    nota_paga
) VALUES
(
	121314,
    1780.00,
    'V',
    '2015-12-08 00:00:00',
    '2015-12-08 00:00:00',
    1,
    true
);

INSERT INTO NotaFiscal
(
	matricula_func,
    valor_nota,
    tipo_movimentacao,
    data_vencimento,
    data_pagamento,
    id_pagamento,
    nota_paga
) VALUES
(
	121314,
    1640.00,
    'V',
    '2015-12-07 00:00:00',
    '2015-12-07 00:00:00',
    1,
    true
);

INSERT INTO Venda
(
	id_produto,
    valor_produto,
    qtd_produto,
    id_nota_fiscal
) VALUES
(
	1,
    700.00,
    2,
    1
);

INSERT INTO Venda
(
	id_produto,
    valor_produto,
    qtd_produto,
    id_nota_fiscal
) VALUES
(
	2,
    380.00,
    1,
    1
);

INSERT INTO Venda
(
	id_produto,
    valor_produto,
    qtd_produto,
    id_nota_fiscal
) VALUES
(
	3,
    180.00,
    1,
    2
);

INSERT INTO Venda
(
	id_produto,
    valor_produto,
    qtd_produto,
    id_nota_fiscal
) VALUES
(
	2,
    380.00,
    2,
    2
);

INSERT INTO Venda
(
	id_produto,
    valor_produto,
    qtd_produto,
    id_nota_fiscal
) VALUES
(
	1,
    700.00,
    1,
    2
);