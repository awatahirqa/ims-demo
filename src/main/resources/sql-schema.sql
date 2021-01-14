create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(id int primary key auto_increment, item_name varchar(40), price DECIMAL(10, 2));
create table if not exists ims.orders(id int primary key auto_increment, CustomerID int, OrderLineID int);
create table if not exists ims.orderline(id int primary key auto_increment, OrderID int, quantity int);