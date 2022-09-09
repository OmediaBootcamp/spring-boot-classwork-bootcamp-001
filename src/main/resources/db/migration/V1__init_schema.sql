CREATE TABLE account (
                                  server_id    INT                 NOT NULL,
                                  login        BIGINT              NOT NULL,
                                  PRIMARY KEY (server_id, login)
);