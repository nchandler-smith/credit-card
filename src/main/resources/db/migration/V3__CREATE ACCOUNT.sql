CREATE TABLE account(
  id int auto_increment PRIMARY KEY,
  cardNumber varchar(36) UNIQUE KEY,
  creditLimit double,
  active boolean,
  cardholderId int,
  merchantId int,
  FOREIGN KEY (cardholderId) REFERENCES cardholder(id),
  FOREIGN KEY (merchantId) REFERENCES merchant(id)
);
