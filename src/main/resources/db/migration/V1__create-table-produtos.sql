create table produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    valor decimal(8,2) not null,
    validade varchar(10) not null,
    descricao varchar(200),
    ativo tinyint not null,
    primary key(id)

);