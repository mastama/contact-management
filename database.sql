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
select * from contacts;
desc contacts;

alter table contacts
change column firstName first_name varchar(100) not null,
change column lastName last_name varchar(100) ;

create table addresses(
    id varchar(100) not null ,
    contact_id varchar(100) not null ,
    street varchar(255),
    city varchar(100),
    province varchar(100),
    country varchar(100),
    postal_code varchar(10),
    primary key (id),
    foreign key fk_contacts_addresses (contact_id) references contacts (id)
);

select * from addresses;
desc addresses;