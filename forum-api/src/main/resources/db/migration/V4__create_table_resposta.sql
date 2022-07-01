CREATE TABLE resposta(
    id SERIAL NOT NULL,
    mensagem VARCHAR(300) NOT NULL,
    dataCriacao TIMESTAMP NOT NULL,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL,
    primary key(id),
    FOREIGN KEY(topico_id) REFERENCES topico(id),
    FOREIGN KEY(autor_id) REFERENCES usuario(id)
);

;
