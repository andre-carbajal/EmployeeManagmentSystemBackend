create table employees (
    id bigint not null auto_increment,
    firstName varchar(255) not null ,
    lastName varchar(255) not null ,
    email varchar(100) not null,

    primary key(id)
);