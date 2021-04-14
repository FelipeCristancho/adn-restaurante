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