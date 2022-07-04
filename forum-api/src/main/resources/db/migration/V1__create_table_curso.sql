CREATE TABLE curso(
    id SERIAL,
    nome VARCHAR(50),
    categoria VARCHAR(50),
    primary key(id)
);

insert into curso values(1, 'Kotlin', 'programação');
