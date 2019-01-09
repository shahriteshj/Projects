DROP TABLE products;

CREATE Table products(
	id numeric(3) primary key,
	pname varchar(20),
	pdescr varchar(120),
	price numeric(8,2)
);
