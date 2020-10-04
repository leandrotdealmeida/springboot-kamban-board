CREATE TABLE bucket (
  id SERIAL PRIMARY KEY,        -- AUTO_INCREMENT integer, as primary key
  uuid UUID UNIQUE NOT NULL,
  position INT NOT NULL,
  name VARCHAR(50) NOT NULL
);

INSERT INTO bucket(uuid, position, name) values
('cb5b7ae2-6346-45f6-a1ae-0969b7abc129', 1, 'EXISTENT');