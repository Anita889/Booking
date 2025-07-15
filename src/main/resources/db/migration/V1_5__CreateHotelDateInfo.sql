CREATE TABLE hotel_date_info_entity (
                                        id SERIAL PRIMARY KEY,
                                        unavailable_dates TEXT,
                                        hotel_id INTEGER REFERENCES hotel_entity(id)
);
