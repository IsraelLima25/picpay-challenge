DELETE FROM tbl_transfer;
DELETE FROM tbl_account;
DELETE FROM tbl_user;

INSERT INTO db_challenge.tbl_user(name, cpf, email, password, user_type) VALUES ('Israel Filho', '331.247.370-50', 'israelslf22@gmail.com', '123', 'COMMON');

INSERT INTO db_challenge.tbl_account(id, balance, user_id) VALUES(
(SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '331.247.370-50'),
400.00, (SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '331.247.370-50'));

INSERT INTO db_challenge.tbl_user(name, cpf, email, password, user_type) VALUES ('Medeiros Construções', '877.402.570-87', 'medeiros@gmail.com', '123456', 'SHOPKEEPER');

INSERT INTO db_challenge.tbl_account(id, balance, user_id) VALUES(
(SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '877.402.570-87'),
900.00, (SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '877.402.570-87'));

INSERT INTO db_challenge.tbl_user(name, cpf, email, password, user_type) VALUES ('Marcos Souza', '332.247.370-50', 'marcos@gmail.com', '341', 'COMMON');

INSERT INTO db_challenge.tbl_account(id, balance, user_id) VALUES(
(SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '332.247.370-50'),
400.00, (SELECT u.id FROM db_challenge.tbl_user u WHERE u.cpf = '332.247.370-50'));