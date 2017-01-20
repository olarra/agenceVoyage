DROP TABLE IF EXISTS services;  

CREATE TABLE services (
idService varchar(70),
type varchar(70),
pays varchar(70),
surface varchar(70),
npieces varchar(70),
addresse varchar(70),
terrain_exterieur varchar(70),
PRIMARY KEY (idService)
);


insert into services values ('1', 'caen', '1973-01-15','caen', 'test','caen', 'test') ;
insert into services values ('2', 'caen', '1973-01-15','caen', 'test','caen', 'test') ;