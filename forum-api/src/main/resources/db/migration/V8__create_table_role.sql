CREATE TABLE role(
    id SERIAL,
    nome VARCHAR(50),
    PRIMARY KEY(id)
);


INSERT INTO role (id, nome) VALUES (1, 'LEITURA_ESCRITA');