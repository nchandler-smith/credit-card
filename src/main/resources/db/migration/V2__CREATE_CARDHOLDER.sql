CREATE TABLE cardholder (
  id int auto_increment PRIMARY KEY,
  name varchar(255),
  ssn varchar(255) NOT NULL UNIQUE
);
