--
-- Database: `supershop`
--
create table product (
id int not null auto_increment,
product_id varchar(255),
product_name varchar(255),
unit_price int,
discount int default 0,
sale_price int,
stock int,
primary key (id),
unique key (product_id)
);