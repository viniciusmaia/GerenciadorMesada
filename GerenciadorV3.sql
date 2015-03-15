create database gerenciadormesadav3;

use gerenciadormesadav3;

create table beneficiado
(
id	integer 	auto_increment,
nome varchar(40) not null,
login varchar(20) not null unique,
senha varchar(20) not null,
email varchar(40) not null unique,

constraint pk_beneficiado primary key (id)
);

create table patrocinador
(
id	integer 	auto_increment,
idbeneficiado integer not null unique,
nome varchar(40) not null,
login varchar(20) not null unique,
senha varchar(20) not null,
email varchar(40) not null unique,

constraint pk_patrocinador primary key (id),
constraint fk_patrocinador_beneficiado foreign key (idbeneficiado) references beneficiado(id)
);


create table mesada
(
id	integer 	auto_increment,
idbeneficiado integer not null,
idpatrocinador integer,
valor double 	not null,
mes integer not null,
ano integer not null, 
recompensa double,
meta double,

constraint pk_mesada primary key (id),
constraint fk_mesada_beneficiado foreign key (idbeneficiado) references beneficiado(id),
constraint fk_mesada_patrocinador foreign key (idpatrocinador) references patrocinador(id)
);

create table categoria
(
id integer auto_increment,
titulo varchar(20) not null,

constraint pk_categoria primary key (id)
);

create table gasto
(
id	integer 	auto_increment,
idcategoria integer not null,
idmesada integer not null,
valor double 	not null,
descricao varchar(50),
datagasto date,

constraint pk_gasto primary key (id),
constraint fk_gasto_categoria foreign key (idcategoria) references categoria(id),
constraint fk_gasto_mesada foreign key (idmesada) references mesada(id)
);
