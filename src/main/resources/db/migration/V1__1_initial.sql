CREATE TABLE chat_histories
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_id    BIGINT NULL,
    prompt     VARCHAR(255) NULL,
    response   VARCHAR(255) NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    CONSTRAINT pk_chat_histories PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_name  VARCHAR(255) NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE chat_histories
    ADD CONSTRAINT FK_CHAT_HISTORIES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);