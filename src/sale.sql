create table sale (
id int not null auto_increment,
user_id varchar(255),
product_id varchar(255),
unit_price int,
sold_price int,
order_date date,
primary key (id),
foreign key (user_id) references customer (username),
foreign key (product_id) references product (product_id)
);