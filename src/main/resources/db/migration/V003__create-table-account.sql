CREATE TABLE tbl_account (
  id bigint AUTO_INCREMENT,
  balance DECIMAL(8,2) NOT NULL,
  user_id bigint NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;