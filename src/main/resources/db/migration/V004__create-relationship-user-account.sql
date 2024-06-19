alter table tbl_account add constraint fk_account
foreign key (user_id) references tbl_user(id);