ALTER TABLE topico ADD COLUMN data_alteracao DATE;

INSERT INTO topico (id, titulo, mensagem, data_criacao, status, curso_id, autor_id)
VALUES (1, 'Dúvidas sobre o kotlin', 'minha funcao let nao funciona', '2022-08-05 12:00:00','NAO_RESPONDIDO', 1, 1);