CREATE TABLE campeonato (
                            id BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            descricao TEXT,
                            data_inicio VARCHAR(255) NOT NULL,
                            data_fim VARCHAR(255) NOT NULL,
                            local VARCHAR(255),
                            cidade VARCHAR(255),
                            estado VARCHAR(255),
                            federacao_id BIGINT NOT NULL,
                            ativo BOOLEAN NOT NULL,
                            CONSTRAINT fk_federacao FOREIGN KEY (federacao_id) REFERENCES federacao(id)
);