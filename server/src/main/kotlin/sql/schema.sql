BEGIN;

CREATE TYPE color AS ENUM (
    'GREEN', 'YELLOW', 'ORANGE', 'BROWN'
);

CREATE TYPE country AS ENUM (
    'RUSSIA', 'UNITED_KINGDOM', 'GERMANY', 'VATICAN'
);

CREATE TYPE music_genre AS ENUM (
    'JAZZ', 'SOUL', 'POP'
);

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     login VARCHAR(40) UNIQUE NOT NULL,
    password_digest VARCHAR(64) NOT NULL
    );

CREATE TABLE IF NOT EXISTS music_band (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(40) NOT NULL CONSTRAINT not_empty_name CHECK(length(name) > 0),
    number_of_participants INTEGER NOT NULL CONSTRAINT positive_number_of_participants CHECK (number_of_participants >= 0),
    album_count INTEGER NOT NULL CONSTRAINT positive_album_count CHECK (album_count >= 0),
    genre music_genre NOT NULL,
    person_name VARCHAR(40) NOT NULL CONSTRAINT not_empty_name_person CHECK(length(person_name) > 0),
    passport_id VARCHAR(40) NOT NULL CHECK(length(passport_id) > 6),
    hair_color color NOT NULL,
    nationality country NOT NULL,
    x_coordinates FLOAT NOT NULL CONSTRAINT positive_x CHECK (x_coordinates >= -645),
    y_coordinates FLOAT NOT NULL,
    x_location double precision NOT NULL,
    y_location INTEGER NOT NULL,
    z_location INTEGER NOT NULL,
    name_location VARCHAR(40) NOT NULL CONSTRAINT not_empty_name_location CHECK(length(name_location) > 0),
    create_by INT NOT NULL REFERENCES users(id) ON DELETE CASCADE
    );
END;