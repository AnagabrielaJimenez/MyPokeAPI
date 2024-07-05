CREATE TABLE pokemon (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         type VARCHAR(255) NOT NULL,
                         level INT NOT NULL,
                         hp INT NOT NULL,
                         attack INT NOT NULL,
                         defense INT NOT NULL
);
