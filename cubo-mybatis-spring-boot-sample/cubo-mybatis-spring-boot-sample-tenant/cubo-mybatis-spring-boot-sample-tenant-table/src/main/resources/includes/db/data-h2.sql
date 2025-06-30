delete
from user_2018;

insert into user_2018 (id, name, age, email)
values (1, 'Jone', 18, 'test1@baomidou.com');

delete
from user_2019;

insert into user_2019 (id, name, age, email)
values (1, 'Jack', 20, 'test2@baomidou.com');

delete
from user_role;
insert into user_role (id, user_id, role_name)
values (1, 1, 'admin');
