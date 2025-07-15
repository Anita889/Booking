CREATE TABLE customer_hotels (
                                 customer_id INTEGER REFERENCES customer_entity(id),
                                 hotel_id INTEGER REFERENCES hotel_entity(id),
                                 PRIMARY KEY (customer_id, hotel_id)
);
