CREATE TABLE account(
  id int auto_increment PRIMARY KEY,
  card_number varchar(36) UNIQUE KEY,
  credit_limit double,
  active boolean,
  cardholder_id int,
  merchant_id int,
  FOREIGN KEY (cardholder_id) REFERENCES cardholder(id),
  FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);
