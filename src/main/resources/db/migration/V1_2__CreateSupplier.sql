CREATE TABLE supplier_entity (
                                 id SERIAL PRIMARY KEY,
                                 user_id INTEGER UNIQUE REFERENCES user_entity(id)
);
