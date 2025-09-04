CREATE TABLE product
(
    id          INT              NOT NULL,
    name        VARCHAR(100),
    description VARCHAR(255),
    price       DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);