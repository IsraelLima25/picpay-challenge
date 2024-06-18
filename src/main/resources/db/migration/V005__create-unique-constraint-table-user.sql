ALTER TABLE tbl_user
ADD CONSTRAINT uc_cpf UNIQUE (cpf);

ALTER TABLE tbl_user
ADD CONSTRAINT uc_email UNIQUE (email);