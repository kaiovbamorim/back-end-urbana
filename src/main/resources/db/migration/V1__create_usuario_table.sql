CREATE TABLE IF NOT EXISTS usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('COMUM', 'ADMIN')),
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS cartao (
    id UUID PRIMARY KEY,
    numero VARCHAR(255) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('COMUM', 'ESTUDANTE', 'TRABALHADOR')),
    id_usuario UUID NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

INSERT INTO "usuario" ("id", "nome", "email", "tipo", "senha")
VALUES (
    gen_random_uuid(),
    'Kaio Amorim',
    'admin@gmail.com',
    'ADMIN',
    '$2a$10$AzB7gqRwvkBcCgv9KkNpGeNhbz/ajDNS56CenRtKcSkfTJjG/7HXe'
);