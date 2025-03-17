CREATE TABLE campeonato_clube (
                                  campeonato_id BIGINT NOT NULL,
                                  clube_id BIGINT NOT NULL,
                                  PRIMARY KEY (campeonato_id, clube_id),
                                  FOREIGN KEY (campeonato_id) REFERENCES campeonato(id) ON DELETE CASCADE,
                                  FOREIGN KEY (clube_id) REFERENCES clube(id) ON DELETE CASCADE
);