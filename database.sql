CREATE DATABASE contact_management;

use contact_management;

create table users(
                      username varchar(100) not null ,
                      password varchar(100) not null ,
                      name varchar(100) not null ,
                      token varchar(100),
                      token_expired_at BIGINT,
                      primary key (username),
                      UNIQUE (token)
);

select * from users;
desc users;

create table contacts(
    id varchar(100) not null ,
    username varchar(100) not null ,
    firstName varchar(100) not null ,
    lastName varchar(100),
    email varchar(100),
    phone varchar(100),
    primary key (id),
    foreign key fk_users_contacts (username) references users (username)
);

desc contacts;