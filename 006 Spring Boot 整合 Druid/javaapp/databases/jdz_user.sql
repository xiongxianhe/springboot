
create database app_test;

create table `jdz_user`
(
    `uid` int unsigned not null auto_increment,
    `name` varchar(64) not null default '',
    `age` tinyint not null default 0,
    `addr` varchar(128) not null default '',
    primary key (`uid`),
    unique (`name`)
)engine = innodb default charset = utf8;