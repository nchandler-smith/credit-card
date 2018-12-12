CREATE TABLE cardholder (
  id int auto_increment PRIMARY KEY,
  first_name varchar(255),
  last_name varchar(255),
  ssn varchar(11) UNIQUE KEY
);
