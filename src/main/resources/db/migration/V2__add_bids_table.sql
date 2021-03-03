CREATE TABLE bids (
    id NVARCHAR(MAX) NOT NULL PRIMARY KEY,
    product_id NVARCHAR(MAX) NOT NULL,
    bid_price DECIMAL(10, 2) NOT NULL,
    bid_time DATETIME2 NOT NULL,
    buyer_email NVARCHAR(MAX) NOT NULL
);

CREATE UNIQUE INDEX idx_unique_pruduct_bid
ON bids (product_id, buyer_email);

ALTER TABLE bids
ADD FOREIGN KEY (product_id) REFERENCES products(id);