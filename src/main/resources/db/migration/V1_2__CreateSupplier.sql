CREATE TABLE supplier_entity (
                                 id SERIAL PRIMARY KEY,
                                 created_date date default DATE(now()),
                                 updated_date date,
                                 removed boolean default false,
                                 user_id INTEGER UNIQUE REFERENCES user_entity(id)
);
