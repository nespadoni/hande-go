CREATE TABLE clube (
                        id BIGSERIAL PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        sigla VARCHAR(50),
                        email VARCHAR(255) UNIQUE NOT NULL,
                        senha VARCHAR(255) NOT NULL,
                        telefone VARCHAR(20),
                        cnpj VARCHAR(18) UNIQUE NOT NULL,
                        estado VARCHAR(50),
                        ativo BOOLEAN NOT NULL DEFAULT TRUE
);
