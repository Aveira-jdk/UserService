insert into roles(role_name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

insert into users(username, password, is_active)
values (' ', ' ', true),
       (' ', ' ', true);

insert into admins(name, email, age, user_id)
values (' ', '@gmail.com', ' ', ' ');
