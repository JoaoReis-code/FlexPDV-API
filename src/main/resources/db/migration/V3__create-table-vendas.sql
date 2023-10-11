CREATE TABLE vendas (

    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantidade BIGINT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data DATETIME NOT NULL,
    produto_id BIGINT NOT NULL,

    CONSTRAINT fk_vendas_produto_id FOREIGN KEY (produto_id) REFERENCES produtos (id)
);