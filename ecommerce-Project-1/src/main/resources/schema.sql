CREATE TABLE IF NOT EXISTS cart (
    cart_id int not null AUTO_INCREMENT primary key
);
CREATE TABLE IF NOT EXISTS product (
	product_id int not null AUTO_INCREMENT primary key,
	name_product varchar(100) not null,
	product_type char(3),
	size char(3),
	quantity int not null,
	price decimal not null
);
CREATE TABLE IF NOT EXISTS cart_item (
	cart_item_id int not null AUTO_INCREMENT primary key,
    cart_id int not null,
	product_id int not null,
	quantity_wished int not null,
	date_added date not null,
	total_amount int not null,
	FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id)
);
CREATE TABLE IF NOT EXISTS customer (
    customer_id int not null AUTO_INCREMENT primary key,
	customer_name varchar(50) not null,
	customer_address varchar(100),
	phone_no char(20) not null,
	cart_id int ,
	FOREIGN KEY (cart_id) REFERENCES cart(cart_id)
);








