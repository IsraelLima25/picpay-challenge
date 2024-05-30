DELETE FROM tbl_account;
DELETE FROM tbl_user;

INSERT INTO db_challenge.tbl_user(name, cpf, email, password, user_type) VALUES ('Israel Filho', '04918032164', 'israelslf22@gmail.com', '123', 'COMMON');

INSERT INTO db_challenge.tbl_account(id, balance, user_id) VALUES(
(SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '04918032164'),
400.00, (SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '04918032164'));

INSERT INTO db_challenge.tbl_user(name, cpf, email, password, user_type) VALUES ('Medeiros Construções', '03698745698', 'medeiros@gmail.com', '123456', 'SHOPKEEPER');

INSERT INTO db_challenge.tbl_account(id, balance, user_id) VALUES(
(SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '03698745698'),
900.00, (SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '03698745698'));