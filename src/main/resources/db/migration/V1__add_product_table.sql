CREATE TABLE products (
    id NVARCHAR(MAX) NOT NULL PRIMARY KEY,
    name NVARCHAR(64),
    details NVARCHAR(MAX),
    bidding_last_date DATETIME2,
    price DECIMAL(10, 2),
    email NVARCHAR(MAX),
    sell_status BIT DEFAULT 0
);

CREATE UNIQUE INDEX idx_unique_products
ON products (id, name, email);

CREATE UNIQUE INDEX idx_unique_named_products
ON products (name, email);