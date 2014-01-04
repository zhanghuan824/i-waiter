create database if not exists paipai character set 'utf8' collate 'utf8_general_ci';

use paipai;
go

create table Location
(
	id int not null primary key auto_increment,
	province varchar(8) not null default '',
	city varchar(10) not null default '',
	district varchar(12) not null default '' /*ÇøÏØ*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table CategoryStrategy
(
	id bigint not null primary key auto_increment,
	peer_split int not null default 2,
	small_split int not null default 4,
	medium_split int not null default 6,
	large_split int not null default 10
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table RestaurantTable
(
	id bigint not null primary key auto_increment,
	peer_table int not null default 0,
	small_table int not null default 0,
	medium_table int not null default 0,
	large_table int not null default 0,
	huge_table int not null default 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table RestaurantQueueStatus
(
	id bigint not null primary key auto_increment,
	peer_v float not null default 0.0,
	small_v float not null default 0.0,
	medium_v float not null default 0.0,
	large_v float not null default 0.0,
	huge_v float not null default 0.0,
	avg_v float not null default 0.0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Restaurant
(
	id bigint not null primary key auto_increment,
	name varchar(20) not null default '',
	location int not null,
	address varchar(32) not null default '',
	type int,
	telphone char(15),
	mobile char(11),
	contact_person varchar(10),
	category_strategy bigint not null,
	tables bigint not null,
	queue_status bigint not null,
	index(queue_status),
	foreign key(queue_status) references RestaurantQueueStatus(id),
	index(tables),
	foreign key (tables) references RestaurantTable(id),
	index(category_strategy),
	foreign key (category_strategy) references CategoryStrategy(id),
	index(location),
	foreign key (location) references Location(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Customer
(
	id bigint not null primary key auto_increment,
	email varchar(32) not null,
	password varchar(32) not null,
	nickname varchar(12) default '',
	gender bit(1) not null default 0,
	birthday datetime,
	mobile char(11) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Reservation
(
	id bigint not null primary key auto_increment,
	restaurant bigint not null,
	customer bigint not null,
	seats int not null,
	create_time timestamp NULL default CURRENT_TIMESTAMP,
	start_time datetime null,
	global_order int,
	status varchar(16),
	index(restaurant),
	foreign key (restaurant) references Restaurant(id),
	index(customer),
	foreign key (customer) references Customer(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


