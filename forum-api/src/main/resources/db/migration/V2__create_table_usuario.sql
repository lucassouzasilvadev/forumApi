CREATE TABLE usuario(
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    primary key(id)
);

insert into usuario values(1, 'ana', 'ana@gmail.com');