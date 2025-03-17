CREATE TABLE rodada (
                        id BIGSERIAL PRIMARY KEY,
                        numero_rodada INT NOT NULL,
                        campeonato_id BIGINT NOT NULL,
                        data_inicio DATE NOT NULL,
                        data_fim DATE NOT NULL,
                        CONSTRAINT fk_rodada_campeonato FOREIGN KEY (campeonato_id) REFERENCES campeonato (id) ON DELETE CASCADE
);
