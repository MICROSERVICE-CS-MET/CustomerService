CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE customer
(
    id         uuid         NOT NULL DEFAULT uuid_generate_v4(),
    full_name  varchar(255) NOT NULL,
    password   varchar(255) NOT NULL,
    email       varchar(255) NOT NULL,

    PRIMARY KEY (id)
);

