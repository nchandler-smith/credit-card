CREATE TABLE cardholder (
  id int auto_increment PRIMARY KEY,
  name varchar(255),
  ssn varchar(11) NOT NULL UNIQUE
);
