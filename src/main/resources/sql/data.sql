-- Add sample records to the store.author table.
set search_path to store;

insert into store.book (time_created, time_updated, title) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Give And Take');
insert into store.book (time_created, time_updated, title) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Zero To One');
insert into store.book (time_created, time_updated, title) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Originals - How Non-Conformists Move The World');

insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Martin', 'Odersky');
insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Spoon', 'Lex');
insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Venners', 'Bill');
insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Sierra', 'Kathy');
insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Bates', 'Bert');
insert into author (time_created, time_updated, family_name, given_name) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Beighly', 'Lynn');
insert into author (time_created, time_updated, family_name, given_name, book_id) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Grant', 'Adam', 1);
insert into author (time_created, time_updated, family_name, given_name, book_id) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Thiel', 'Peter', 2);
insert into author (time_created, time_updated, family_name, given_name, book_id) values ('2016-08-09 20:15:40.174', '2016-08-09 20:15:40.174', 'Grant', 'Adam', 3);