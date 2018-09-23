--
-- Database: `supershop`
--

create table customer (
id int not null auto_increment,
username varchar(255),
password varchar(255),
card_no int,
card_balance int,
primary key (id),
unique key (username),
unique key (card_no)
);