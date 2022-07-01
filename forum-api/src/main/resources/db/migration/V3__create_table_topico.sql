CREATE TABLE topico(
    id SERIAL NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(30) NOT NULL,
    curso_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    primary key(id),
    FOREIGN KEY(curso_id) REFERENCES curso(id),
    FOREIGN KEY(autor_id) REFERENCES usuario(id)
);

