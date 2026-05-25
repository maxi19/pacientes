
CREATE TABLE bebida (
  id int NOT NULL AUTO_INCREMENT,
  precio int DEFAULT NULL,
  descripcion varchar(100) DEFAULT NULL,
  titulo varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `postre` (
  id int NOT NULL AUTO_INCREMENT,
  precio int DEFAULT NULL,
  descripcion varchar(100) DEFAULT NULL,
  titulo varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE plato (
  id int NOT NULL AUTO_INCREMENT,
  precio int DEFAULT NULL,
  descripcion varchar(100) DEFAULT NULL,
  titulo varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE usuario (
  id int NOT NULL AUTO_INCREMENT,
  usuario varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE menu(
  id INT NOT NULL AUTO_INCREMENT,
  titulo varchar(100) DEFAULT NULL,
  precio int DEFAULT NULL,
  descripcion varchar(100) DEFAULT NULL,
  idPlato int DEFAULT NULL,
  idPostre int DEFAULT NULL,
  idBebida int DEFAULT NULL,
  tipo varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
  );

insert into usuario(usuario, password) values ("admin","123456");

