CREATE TABLE t_users (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         username VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         role VARCHAR(50) NOT NULL,
                         PRIMARY KEY (id)
);