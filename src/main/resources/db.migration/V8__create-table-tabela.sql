CREATE TABLE tabelas (
                         id BIGINT PRIMARY KEY,
                         campeonato_id BIGINT,
                         FOREIGN KEY (campeonato_id) REFERENCES campeonato(id)
);
