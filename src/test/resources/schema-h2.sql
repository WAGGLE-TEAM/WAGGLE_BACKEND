CREATE TABLE MEMBER
(
    id            SERIAL PRIMARY KEY,
    user_id       VARCHAR(30) UNIQUE NOT NULL,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(30) NOT NULL
);