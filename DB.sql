CREATE DATABASE buen_gusto;
USE buen_gusto;

CREATE TABLE rol(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    rol VARCHAR (30) not null
);
CREATE TABLE usuario (
    id int not null PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR (40) not null,
    telefono VARCHAR (10) not null,
    usuario VARCHAR (40) not null,
    contrasena enum('texto', 'sha1', 'md5'),
    metodo     varchar(40),
    fkid_rol int not null,
    FOREIGN KEY (fkid_rol) REFERENCES rol (id)
);

CREATE TABLE estado(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    estado VARCHAR (30) not null
);

CREATE TABLE domicilio (
    id int not null PRIMARY KEY AUTO_INCREMENT,
    fecha DATE not null,
    fkid_usuario int not null,
    fkid_estado int not null,
    FOREIGN KEY (fkid_usuario) REFERENCES usuario (id),
    FOREIGN KEY (fkid_estado) REFERENCES estado (id)
);

CREATE TABLE unidad(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    unidad VARCHAR (30) NOT NULL    
);

CREATE TABLE AGRUPACION(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    agrupacion VARCHAR (30) not null 
);

CREATE TABLE producto(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR (30) not null,
    precio FLOAT not null,
    cantidad int not null,
    descripcion VARCHAR (60) not null,
    imagen VARCHAR (120) not null,
    fkid_unidad int not null,
    fkid_agrupacion int not null,
    FOREIGN KEY (fkid_unidad) REFERENCES unidad (id),
    FOREIGN KEY (fkid_agrupacion) REFERENCES agrupacion (id)         
);

CREATE TABLE detalle_domicilio(
    id int not null PRIMARY KEY AUTO_INCREMENT,
    valor FLOAT not null,
    cantidad int not null,
    fkid_domicilio int not null,
    fkid_producto int not null, 
    FOREIGN KEY (fkid_domicilio) REFERENCES domicilio (id),
    FOREIGN KEY (fkid_producto) REFERENCES producto (id)
);

INSERT INTO UNIDAD (unidad) VALUES ("unidad");
INSERT INTO UNIDAD (unidad) VALUES ("libras");


INSERT INTO AGRUPACION (agrupacion) VALUES ("frutas");
INSERT INTO AGRUPACION (agrupacion) VALUES ("verduras");
INSERT INTO AGRUPACION (agrupacion) VALUES ("carnes");
INSERT INTO AGRUPACION (agrupacion) VALUES ("aseo");
INSERT INTO AGRUPACION (agrupacion) VALUES ("snacks");

insert into producto (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("manzanas",1500,30,"manzanas por unidad","https://dl.dropboxusercontent.com/s/6l7eetuibn09yeo/manzanas.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("papayas",5000,20,"papayas por unidad","https://dl.dropboxusercontent.com/s/07idzh820603obu/papaya.jpg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("mandarinas",2000,50,"mandarinas por unidad","https://dl.dropboxusercontent.com/s/2hrnpkarg0iczwp/mandarina.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("guanabanas",7000,25,"guanabanas por unidad","https://dl.dropboxusercontent.com/s/b0iuv6zy9z8nd3e/guanabana.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("uvas",5500,25,"uvas por libra","https://dl.dropboxusercontent.com/s/dtffanruarx69m6/uvas.jpeg?dl=0",1,2);
