CREATE TABLE partida(
                         id BIGSERIAL PRIMARY KEY,
                         time_casa_id BIGINT NOT NULL,
                         time_visitante_id BIGINT NOT NULL,
                         rodada_id BIGINT NOT NULL,
                         gols_casa INT DEFAULT 0,
                         gols_visitante INT DEFAULT 0,
                         status VARCHAR(50) DEFAULT 'NAO_REALIZADO',
                         CONSTRAINT fk_partida_time_casa FOREIGN KEY (time_casa_id) REFERENCES clube (id) ON DELETE CASCADE,
                         CONSTRAINT fk_partida_time_visitante FOREIGN KEY (time_visitante_id) REFERENCES clube (id) ON DELETE CASCADE,
                         CONSTRAINT fk_partida_rodada FOREIGN KEY (rodada_id) REFERENCES rodada (id) ON DELETE CASCADE
);
