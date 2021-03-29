INSERT INTO UNIDAD (unidad) VALUES ("unidad");
INSERT INTO UNIDAD (unidad) VALUES ("libras");


INSERT INTO AGRUPACION (agrupacion) VALUES ("frutas");
INSERT INTO AGRUPACION (agrupacion) VALUES ("verduras");
INSERT INTO AGRUPACION (agrupacion) VALUES ("aseo");
INSERT INTO AGRUPACION (agrupacion) VALUES ("snacks");

insert into producto (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("manzanas",1500,30,"manzanas por unidad","./img/logo.png",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("papayas",5000,20,"papayas por unidad","./img/logo.png",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("mandarinas",2000,50,"mandarinas por unidad","./img/logo.png",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("guanabanas",7000,25,"guanabanas por unidad","./img/logo.png",1,1);
