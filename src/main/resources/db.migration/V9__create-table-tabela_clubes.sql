CREATE TABLE tabela_clubes (
    tabela_id BIGINT,
    clube_id BIGINT,
    PRIMARY KEY (tabela_id, clube_id),

    FOREIGN KEY (tabela_id) REFERENCES tabelas(id),
    FOREIGN KEY (clube_id) REFERENCES clube(id)
);