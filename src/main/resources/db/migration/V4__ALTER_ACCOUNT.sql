ALTER TABLE account
  ADD merchant_id int NOT NULL,
  ADD card_holder_id int NOT NULL;

ALTER TABLE account ADD CONSTRAINT fk_merchant_id FOREIGN KEY (merchant_id) REFERENCES merchant(id);
ALTER TABLE account ADD CONSTRAINT fk_card_holder_id FOREIGN KEY (card_holder_id) REFERENCES card_holder(id);