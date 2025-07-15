CREATE TABLE supplier_hotels (
                                 supplier_id INTEGER REFERENCES supplier_entity(id),
                                 hotel_id INTEGER REFERENCES hotel_entity(id),
                                 PRIMARY KEY (supplier_id, hotel_id)
);
