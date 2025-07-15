CREATE TABLE hotel_entity (
                              id SERIAL PRIMARY KEY,
                              hotel_name VARCHAR(255),
                              address VARCHAR(255),
                              country VARCHAR(255),
                              city VARCHAR(255),
                              created_date date,
                              updated_date date,
                              removed boolean default false
);
