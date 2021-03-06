--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 000, INCREMENT BY 1) PRIMARY KEY,
  COUNTRY VARCHAR(10),
  name VARCHAR(30),
  date1 VARCHAR(30),
  date2 VARCHAR(30),
  sex VARCHAR(1),
  SKILL VARCHAR(500)
);