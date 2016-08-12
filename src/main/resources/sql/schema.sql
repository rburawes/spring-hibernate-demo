set timezone = 'UTC';

create schema if not exists store;

drop table if exists store.author;
drop table if exists store.book;

create table store.author (
  id  bigserial not null,
  time_created timestamp not null,
  time_updated timestamp,
  family_name varchar(255) not null,
  given_name varchar(255) not null,
  book_id int8,
primary key (id)
);

create table store.book (
  id  bigserial not null,
  time_created timestamp not null,
  time_updated timestamp,
  title varchar(255),
  primary key (id)
);

alter table store.author add constraint book_id foreign key (book_id)  references store.book;