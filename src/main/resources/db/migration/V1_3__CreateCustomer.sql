CREATE TABLE customer_entity (
                                 id SERIAL PRIMARY KEY,
                                 user_id INTEGER UNIQUE REFERENCES user_entity(id),
                                 card_number VARCHAR(255),
                                 amount VARCHAR(255),
                                 currency VARCHAR(50),
                                 created_date date,
                                 updated_date date,
                                 removed boolean default false
);
