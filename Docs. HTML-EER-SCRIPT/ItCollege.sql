create database dbcollege;
use dbcollege;

create table user (
id_user INT NOT NULL AUTO_INCREMENT,
name_user VARCHAR(30)NOT NULL,
contact VARCHAR(15) NOT NULL,
login VARCHAR(15) NOT NULL unique,
password_user VARCHAR(8) NOT NULL,
profile_user VARCHAR(20) NOT NULL,
address  VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL,
nationality  VARCHAR(20)NOT NULL,
gender ENUM ('M', 'F'),
primary key (id_user)
);

insert into user 
(id_user ,name_user ,contact ,login,password_user ,profile_user,address ,email ,nationality ,gender)
values
('2018000', 'KATIA MORENO','086 4546042', 'adm', 'adm', 'adminitrador', '59 beach hill', 'adm@itcollege.ie', 'Brasilian', 'F');
insert into user 
(name_user ,contact ,login,password_user ,profile_user,address ,email ,nationality ,gender)
values
('KALIENY MORENO','086 8885959', 'mark', 'mark', 'marketing', '59 beach hill', 'mark@itcollege.ie', 'Brasilian', 'F');

select * from user;

create table course (
   id_course INT NOT NULL AUTO_INCREMENT,
   name_course VARCHAR(30) NOT NULL UNIQUE,
   time_course VARCHAR(30) NOT NULL,
   year_couser year default '2018',
   primary key (id_course)
   );
   
   insert into course
  (id_course,name_course,time_course,year_couser)
  values
  ('1', 'JAVA', 'Full Time', '2018');
   insert into course
  (name_course,time_course)
  values
  ( 'PHP', 'Full Time');
   insert into course
  (name_course,time_course)
  values
  ( 'HTML', 'Full Time'); insert into course
  (name_course,time_course)
  values
  ( 'DATABASE', 'Full Time');
   insert into course
  (name_course,time_course)
  values
  ( 'NETWORK', 'Part Time');
  select*from course;
  select*from user;
  
  alter table user add column course_current varchar(15);
  desc user
;

alter table user add foreign key(course_current) references course(id_course);

alter table user drop column course_current;
alter table user add column course_current int not null;

desc user;

insert into user 
(id_user ,name_user ,contact ,login,password_user ,profile_user,address ,email ,nationality ,gender)
values
('2018004', 'Philip Donald Estridge','081 888 9999', 'std', 'std', 'student', 'Paris Street', 'pde@gmail.com', 'American', 'M');


select*from user;

select U.id_user, U.Name_user,U.course_current, C.id_course, C.name_course, C.time_course,C.year_couser
from user as U inner join course as C
on C.id_course = course_current
order by C.time_course;
 
desc course;
select*from course;


select *from course where name_course like 'Ne%';

alter table course add column lecture Varchar (20);
alter table user add column course Varchar (20);