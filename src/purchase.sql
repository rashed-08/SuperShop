create table purchase(
id int not null auto_increment,
user_id varchar(255),
product_id varchar(255),
primary key (id),
foreign key (user_id) references customer (username),
foreign key (product_id) references product (product_id)
);