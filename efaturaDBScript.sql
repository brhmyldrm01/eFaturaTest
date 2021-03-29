Create schema efatura;

create table User(
id int primary key AUTO_INCREMENT, 
tckn_vkn varchar(11) ,
email varchar(45) not null unique  ,
username varchar(45) ,
user_password varchar (45)

);

	insert into User (tckn_vkn,email,username,user_password)
 values("22222222222","destek@java.com.tr","destek","xxxxxxxx");
 
 insert into User (tckn_vkn,email,username,user_password)
 values("11111111111","destek1@java.com.tr","destek","xxxxxxxx");

 select * from User;
 

 
