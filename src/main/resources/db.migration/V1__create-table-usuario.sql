CREATE TABLE usuario(
    id       BIGSERIAL UNIQUE PRIMARY KEY,
    nome     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    senha    VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL,
    cpf      VARCHAR(255) NOT NULL UNIQUE,
    cidade   VARCHAR(255) NOT NULL,
    estado   VARCHAR(255) NOT NULL,
    ativo   BOOLEAN NOT NULL
);