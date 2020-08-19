drop table if exists employee;
create table employee (
    name varchar(20),
    employee_id varchar(20) primary key,
    department_id varchar(20),
    gender varchar(20),
    tel varchar(20),
    address varchar(200),
    age int,
    create_time timestamp default current_timestamp,
    modify_time timestamp default current_timestamp
);

drop table if exists department;
create table department (
    department_id varchar(20) primary key,
    name varchar(20)
);
