CREATE TABLE hotel_date_info_entity (
                                        id SERIAL PRIMARY KEY,
                                        unavailable_dates TEXT,
                                        created_date date default DATE(now()),
                                        updated_date date,
                                        removed boolean default false,
                                        hotel_id INTEGER REFERENCES hotel_entity(id)
);
