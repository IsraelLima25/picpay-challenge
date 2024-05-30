CREATE TABLE tbl_user (
  id bigint AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  user_type VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;