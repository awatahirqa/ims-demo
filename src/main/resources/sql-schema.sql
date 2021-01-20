create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(id int primary key auto_increment, item_name varchar(40), price DECIMAL(10, 2));
create table if not exists ims.orders(OrderID int primary key auto_increment NOT NULL, CustomerID INT NOT NULL,  FOREIGN KEY (CustomerID) REFERENCES ims.customers(id));
create table if not exists ims.orderline(orderline_id int PRIMARY KEY  auto_increment NOT NULL, item_id int, order_id int, cost NUMERIC(19,2), quantity INT, foreign key(item_id) references ims.item(id), foreign key(order_id) references ims.orders(OrderID));