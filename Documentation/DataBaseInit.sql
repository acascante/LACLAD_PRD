set FOREIGN_KEY_CHECKS=0;
insert into `LACLAD_PRD`.`locations` values (1,1,'Costa Rica',1);
set FOREIGN_KEY_CHECKS=1;

INSERT INTO `LACLAD_PRD`.`system_users` (`id`,`version`,`password`,`status`,`type`,`user_name`)
VALUES(1,1,'admin','1',0,'admin');
