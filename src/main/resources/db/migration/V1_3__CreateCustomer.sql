CREATE TABLE customer_entity (
                                 id SERIAL PRIMARY KEY,
                                 user_id INTEGER UNIQUE REFERENCES user_entity(id),
                                 card_number VARCHAR(255),
                                 amount DOUBLE PRECISION,
                                 currency VARCHAR(50),
                                 created_date date default DATE(now()),
                                 updated_date date,
                                 removed boolean default false
);
