CREATE TABLE campeonato (
                            id             BIGSERIAL UNIQUE PRIMARY KEY,
                            nome           VARCHAR(255) NOT NULL,
                            descricao      VARCHAR(255) NOT NULL UNIQUE,
                            dataInicio     VARCHAR(255) NOT NULL,
                            dataFim        VARCHAR(255) NOT NULL,
                            local          VARCHAR(255) NOT NULL,
                            cidade         VARCHAR(255) NOT NULL,
                            estado         VARCHAR(255) NOT NULL,
                            federacao_id   BIGINT,
                            ativo          BOOLEAN NOT NULL,

                            CONSTRAINT fk_federacao_id FOREIGN KEY (federacao_id) REFERENCES federacao(id) ON DELETE SET NULL
);