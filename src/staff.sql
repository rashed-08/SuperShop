--
-- Database: `supershop`
--

create table staff (
id int not null auto_increment,
username varchar(255),
password varchar(255),
email varchar(255),
role varchar(255),
primary key (id),
unique key (username)
);