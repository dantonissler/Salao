-- ---------------
-- Functions
-- ---------------

DROP FUNCTION IF EXISTS `CPF_Valido`;
DELIMITER $$
	CREATE FUNCTION CPF_Valido(@CPF VARCHAR(11)) RETURNS CHAR(1) AS BEGIN
	  DECLARE @INDICE INT,
			  @SOMA INT,
			  @DIG1 INT,
			  @DIG2 INT,
			  @CPF_TEMP VARCHAR(11),
			  @DIGITOS_IGUAIS CHAR(1),
			  @RESULTADO CHAR(1)
			  
	  SET @RESULTADO = 'N'

	  SET @CPF_TEMP = SUBSTRING(@CPF,1,1)

	  SET @INDICE = 1
	  SET @DIGITOS_IGUAIS = 'S'

	  WHILE (@INDICE <= 11)
	  BEGIN
		IF SUBSTRING(@CPF,@INDICE,1) <> @CPF_TEMP
		  SET @DIGITOS_IGUAIS = 'N'
		SET @INDICE = @INDICE + 1
	  END;
      
	  IF @DIGITOS_IGUAIS = 'N' 
	  BEGIN
		--Cálculo do 1º dígito
		SET @SOMA = 0
		SET @INDICE = 1
		WHILE (@INDICE <= 9)
		BEGIN
		  SET @Soma = @Soma + CONVERT(INT,SUBSTRING(@CPF,@INDICE,1)) * (11 - @INDICE);
		  SET @INDICE = @INDICE + 1
		END ;
        
		SET @DIG1 = 11 - (@SOMA % 11)
		IF @DIG1 > 9
			SET @DIG1 = 0;
			SET @SOMA = 0
			SET @INDICE = 1
			WHILE (@INDICE <= 10)BEGIN
			  SET @Soma = @Soma + CONVERT(INT,SUBSTRING(@CPF,@INDICE,1)) * (12 - @INDICE);
			  SET @INDICE = @INDICE + 1;
		END ;

		SET @DIG2 = 11 - (@SOMA % 11)
		IF @DIG2 > 9
		  SET @DIG2 = 0;

		IF (@DIG1 = SUBSTRING(@CPF,LEN(@CPF)-1,1)) AND (@DIG2 = SUBSTRING(@CPF,LEN(@CPF),1))
		  SET @RESULTADO = 'S'
		ELSE
		  SET @RESULTADO = 'N'
	  END ;
	  RETURN @RESULTADO
	END ;
DELIMITER ;

DROP FUNCTION IF EXISTS `CPF_Existe_funcionario`;
DELIMITER $$
	CREATE FUNCTION CPF_Existe_funcionario(@CPF VARCHAR(11)) RETURNS CHAR(1) AS BEGIN
		DECLARE @CPFs 
        SELECT CPF_Funcionario FROM Cadastro_Funcionario;
		IF(@CPF) THEN
        
        ELSE
        
        END IF;
    END ;
DELIMITER ;

-- ---------------
-- Procedures
-- ---------------

-- Realizar update no produto apos venda 
DROP PROCEDURE IF EXISTS `data_Venda` ;
DELIMITER $$
	CREATE PROCEDURE Realizar_Vendas (in qtdade int)BEGIN
		UPDATE Estoque SET estoque_atualizado = estoque_atualizado - qtdade WHERE id_Estoque = Estoque_id_Estoque;
	END $$
DELIMITER ;

-- Realizar update no produto apos venda 
DROP PROCEDURE IF EXISTS `data_Venda` ;
DELIMITER $$
	CREATE PROCEDURE valorTotal (in qtdade int, in valor decimal(10,2), out valor_total decimal(10,2))BEGIN
		SET valor_total = valor * qtdade;
	END $$
DELIMITER ;

-- ---------------
-- Views
-- ---------------
CREATE VIEW itens_fornecidos_por_fornecedor_qtd
AS
	SELECT cnpj_Fornecedor
		, nome_Fornecedor
        , nome_empresa
        , eamil__Fornecedor
        , qtd_produto_fornecido
        , nome
	FROM
		cadastro_fornecedor
	INNER JOIN
		itens_fornecedor
    on
		itens_fornecidos.id_fornecedor = cadastro_fornecedor.fornecedor_id_fornecedor;
        
CREATE VIEW Relatorio_de_gastos_e_pagamentos
AS
	SELECT valor_pagamento
		, data_pagamento
        , valor_gasto_geral
	FROM
		gastos
	INNER JOIN
		pagamento_conta
    on
		gastos.id_gastos = pagamento_conta.gastos_id_gastos;
	
CREATE VIEW Relatorio_estoque_produto
AS
	SELECT qtd_estoque
		, estoque_min
        , valor_produto
        , qtd_estoque_atualizado
        , nome_produto
        , descrição_produto
        , qtd_produto
        , valor_produto
	FROM
		estoque
	INNER JOIN
		cadastro_produto
    on
		estoque.id_produto = cadastro_produto.id_produto;
        
        
-- ---------------
-- Triggers
-- ---------------

-- incerção da data na venda
DROP TRIGGER IF EXISTS `data_Venda` ;
DELIMITER $$
	CREATE TRIGGER data_Venda BEFORE UPDATE ON venda_produto FOR EACH ROW BEGIN
		INSERT INTO venda_produto (data_Venda) VALUES(NOW());
	END$$
DELIMITER ;

-- update no valor do produto apos venda
DROP TRIGGER IF EXISTS `UpProdutoAfterVenda` ;
DELIMITER $$
	CREATE TRIGGER Up_Estoque_Venda AFTER UPDATE ON itens_venda FOR EACH ROW BEGIN
		CALL Realizar_Vendas (new.quantidade);
	END$$
DELIMITER ;

-- update no valor do produto apos venda
DROP TRIGGER IF EXISTS `UpProdutoAfterVenda` ;
DELIMITER $$
	CREATE TRIGGER UpEstoqueAfterVenda AFTER UPDATE ON itens_venda FOR EACH ROW BEGIN
		CALL RealizarVendas (new.quantidade);
	END$$
DELIMITER ;

DROP TRIGGER IF EXISTS `DelProduto` ;
DELIMITER $$
	CREATE TRIGGER DelProduto BEFORE DELETE ON Cadastro_Produto FOR EACH ROW BEGIN
		INSERT INTO Produto_Del (`nome`, `descricao`, `qtd`, `valor`)VALUES (old.nome_Produto, old.descricao_Produto, old.qtd_Produto, old.valor_produto);
	END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER nome_trigger BEFORE INSERT ON nome_tabela 
FOR EACH ROW 
BEGIN 
    DECLARE v_qtd_cpf INT;

    SELECT COUNT(cpf) INTO v_qtd_cpf FROM nome_tabela WHERE cpf = NEW.cpf;

    IF (v_qtd_cpf <> 0) THEN 
      SIGNAL SQLSTATE '450000' SET MESSAGE_TEXT = "O cpf já foi cadastrado no banco de dados";
    END IF ;
END ;
DELIMITER ;
