CREATE TABLE tbl_transfer (
  id BIGINT AUTO_INCREMENT,
  id_payer BIGINT,
  id_payee BIGINT,
  value_transfer DECIMAL(8,2),
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;

alter table tbl_transfer add constraint fk_id_payer
foreign key (id_payer) references tbl_user(id);

alter table tbl_transfer add constraint fk_id_payee
foreign key (id_payee) references tbl_user(id);