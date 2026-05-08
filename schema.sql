CREATE TABLE phones (
                        id SERIAL PRIMARY KEY,
                        type VARCHAR(50) NOT NULL,
                        brand VARCHAR(100),
                        model VARCHAR(100),
                        price DOUBLE PRECISION,
                        storage INTEGER
);