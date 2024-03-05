show databases;
use library;
show tables;
select * from book;
select * from student;
select * from issuebook;
delete from issuebook where issueid=9;
delete from book where bookid=3;
update issuebook set bookstatus='Issued' where issueid=2;