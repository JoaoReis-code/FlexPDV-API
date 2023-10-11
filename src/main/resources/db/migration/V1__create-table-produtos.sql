CREATE TABLE produtos(

    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(8,2) NOT NULL,
    validade DATETIME NOT NULL,
    descricao VARCHAR(200),
    ativo tinyint NOT NULL

);