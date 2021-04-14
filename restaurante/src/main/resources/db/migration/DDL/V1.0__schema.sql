create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE client (
id int(11) not null auto_increment,
dni int(11) not null,
last_name varchar(255) not null,
name varchar(255) not null,
telephone varchar(255) null,
primary key (id));

CREATE TABLE dishe (
dish_id bigint not null auto_increment,
dish_name varchar(255),
price double precision not null,
primary key (dish_id));

CREATE TABLE sale (
id int(11) not null auto_increment,
sale_date date not null,
client_id int(11) not null,
dish_id bigint not null,
primary key (id),
FOREIGN key (client_id) REFERENCES client(id),
FOREIGN key (dish_id) REFERENCES dishe(dish_id));