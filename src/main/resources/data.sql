insert into user
(id, user_name, email, password, profile, create_date, last_modified_date) values 
(1, 'haluk', 'hincidelen@hotmail.com', 'qwe', 'admin', sysdate(),  sysdate()),
(2, 'hamid', 'hincidelen@gmail.com', 'asd', 'admin', sysdate(),  sysdate());

insert into stock
(id, code, name, price, create_date, last_modified_date) values
(1, 'AKBNK', 'Ak Bank', 23.55, sysdate(), sysdate() ),
(2, 'YKBNK', 'Yapı Kredi', 16.15, sysdate(), sysdate() );

insert into stock_holding
(id, stock_id, user_id, amount, create_date) values
(1, 1, 1, 23, sysdate() ),
(2, 2, 2, 12, sysdate() );

