CREATE SCHEMA if not exists prod;

create table prod.User (
  id bigint not null,
  date datetime(6),
  primary key (id)
) engine=InnoDB;