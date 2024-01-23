insert into note(important, created_at, id, author, content, title) values (true, CURRENT_DATE, 1, '4861a891-39a5-4d12-a17b-a789fbd77c19', 'Hola como estas', 'Hola Mundo');
insert into note_tags values (1, 'hola');
insert into note(important, created_at, id, author, content, title) values (true, CURRENT_DATE, 2, '4861a891-39a5-4d12-a17b-a789fbd77c19', 'Hola como estas', 'Hola Mundo');
insert into note_tags values (2, 'hola');
insert into note(important, created_at, id, author, content, title) values (true, CURRENT_DATE, 3, '4861a891-39a5-4d12-a17b-a789fbd77c19', 'Hola como estas', 'Hola Mundo');
insert into note_tags values (3, 'hola');
insert into note(important, created_at, id, author, content, title) values (true, CURRENT_DATE, 4, '4861a891-39a5-4d12-a17b-a789fbd77c19', 'Hola como estas', 'Hola Mundo');
insert into note_tags values (4, 'hola');
insert into note(important, created_at, id, author, content, title) values (true, CURRENT_DATE, 5, '4861a891-39a5-4d12-a17b-a789fbd77c19', 'Hola como estas', 'Hola Mundo');
insert into note_tags values (5, 'hola');

insert into user_entity (account_non_expired, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at, id, avatar, full_name, password, username) values( true, true, true, true, CURRENT_DATE, CURRENT_DATE, '4861a891-39a5-4d12-a17b-a789fbd77c19'::UUID, 'a', 'javi', '1', 'javi');
insert into user_entity (account_non_expired, account_non_locked, credentials_non_expired, enabled, created_at, last_password_change_at, id, avatar, full_name, password, username) values( true, true, true, true, CURRENT_DATE, CURRENT_DATE, '47264aaa-ae4e-4cf8-8aa9-0c50aebf8692'::UUID, 'a', 'juan', '1', 'juan');

insert into user_roles(roles, user_id) values (1, '47264aaa-ae4e-4cf8-8aa9-0c50aebf8692'::UUID);
insert into user_roles(roles, user_id) values (0, '4861a891-39a5-4d12-a17b-a789fbd77c19'::UUID);