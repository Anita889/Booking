CREATE TABLE user_entity (
                             id SERIAL PRIMARY KEY,
                             first_name VARCHAR(255),
                             last_name VARCHAR(255),
                             password VARCHAR(255),
                             country VARCHAR(255),
                             city VARCHAR(255),
                             email VARCHAR(255),
                             created_date date,
                             updated_date date,
                             removed boolean default false
);
