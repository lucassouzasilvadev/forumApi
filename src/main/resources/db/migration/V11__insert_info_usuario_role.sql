insert into
    usuario(nome, email, senha)
values
    ('admin', 'admin@gmail.com', '$2y$10$nAN49KrHOS1k7psU43y5l.aOG0A3BBDwxGbEEzpFTe.8OrutoShcW');

INSERT INTO `role`(nome) values ('ADMIN');

INSERT INTO usuario_role(usuario_id, role_id) VALUES(2, 2);