CREATE TABLE federacao(
                          id       BIGSERIAL UNIQUE PRIMARY KEY,
                          nome     VARCHAR(255) NOT NULL,
                          email    VARCHAR(255) NOT NULL UNIQUE,
                          senha    VARCHAR(255) NOT NULL,
                          telefone VARCHAR(255) NOT NULL,
                          cnpj     VARCHAR(255) UNIQUE,
                          estado   VARCHAR(255) NOT NULL,
                          ativo   BOOLEAN NOT NULL
);