CREATE TABLE cardholder (
  id int auto_increment PRIMARY KEY,
  firstName varchar(255),
  lastName varchar(255),
  ssn varchar(11) UNIQUE KEY
);
