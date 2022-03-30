drop database if exists prueba;
create database prueba;

use prueba;

create table persona (
    id int primary key,
    nombre varchar(64),
    apellido varchar(64),
    fecha date );
    
insert into persona value(1, 'Juan', 'Perez', '2017-08-17');
insert into persona value(2, 'Ana', 'Maria', '2017-01-10');
insert into persona value(3, 'Elena', 'Ortiz', '2010-01-01');
insert into persona value(4, 'Ivan', 'Valdes', '2015-11-11');

rename table persona to personas;