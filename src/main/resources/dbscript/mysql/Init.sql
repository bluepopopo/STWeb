-- create user
grant all PRIVILEGES  on stwebdb.* to scott@'%' identified by 'tiger';
grant all PRIVILEGES on stwebdb.* to scott@localhost identified by 'tiger';

-- init schema
drop schema if exists stweb;
create schema stweb DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

-- create tables
use stweb;

-- drop table
drop table if exists user;
drop table if exists post;
drop table if exists comment;

-- create user table
create table user
  (
    id            	 integer not null primary key auto_increment,
    user_name        varchar (500) not null ,
    password         varchar (500) not null ,
    create_by        integer,
    creation_date    datetime,
    last_update_by   integer,
    last_update_date datetime
  ) ;

-- create post table
create table post
  (
    id            	 integer not null primary key auto_increment,
    title          	 varchar (500) not null ,
    short_desc       varchar (500) ,
    content          text ,
    create_by        integer,
    creation_date    datetime,
    last_update_by   integer,
    last_update_date datetime
  ) ;

-- create article table
create table comment
  (
    id            	 integer not null primary key auto_increment,
    comment          varchar (500) not null ,
    create_by        integer,
    creation_date    datetime,
    last_update_by   integer,
    last_update_date datetime
  ) ;
 
-- prepare data
insert into user(user_name, password)
values ('admin', 'admin');

commit; 
  