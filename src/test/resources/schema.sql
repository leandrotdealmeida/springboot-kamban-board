CREATE TABLE list (
  id SERIAL PRIMARY KEY,        -- AUTO_INCREMENT integer, as primary key
  uuid UUID NOT NULL,
  position INT NOT NULL,
  name VARCHAR(50) NOT NULL
);