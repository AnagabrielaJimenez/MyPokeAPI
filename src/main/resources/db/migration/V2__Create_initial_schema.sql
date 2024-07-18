CREATE TABLE pokemon (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         type VARCHAR(255) NOT NULL,
                         level INT NOT NULL,
                         experience INT NOT NULL,
                         attack INT NOT NULL,
                         defense INT NOT NULL,
                         trainer_id BIGINT,
                         FOREIGN KEY (trainer_id) REFERENCES trainer(id)
);

CREATE TABLE trainer (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         region VARCHAR(255) NOT NULL,
                         username VARCHAR(255) UNIQUE NOT NULL
);