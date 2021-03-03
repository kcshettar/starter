CREATE TABLE products (
    id NVARCHAR(MAX) NOT NULL PRIMARY KEY,
    name NVARCHAR(64) NOT NULL,
    details NVARCHAR(MAX) NOT NULL,
    bidding_last_date DATETIME2 NOT NULL,
    min_price DECIMAL(10, 2) NOT NULL,
    seller_email NVARCHAR(MAX) NOT NULL,
    bid_status BIT DEFAULT 0
);

CREATE UNIQUE INDEX idx_unique_products
ON products (id, name, seller_email);

CREATE UNIQUE INDEX idx_unique_named_products
ON products (name, seller_email);