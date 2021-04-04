INSERT INTO UNIDAD (unidad) VALUES ("unidad");
INSERT INTO UNIDAD (unidad) VALUES ("libras");


INSERT INTO AGRUPACION (agrupacion) VALUES ("frutas");
INSERT INTO AGRUPACION (agrupacion) VALUES ("verduras");
INSERT INTO AGRUPACION (agrupacion) VALUES ("aseo");
INSERT INTO AGRUPACION (agrupacion) VALUES ("snacks");

insert into producto (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("manzanas",1500,30,"manzanas por unidad","https://dl.dropboxusercontent.com/s/6l7eetuibn09yeo/manzanas.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("papayas",5000,20,"papayas por unidad","https://dl.dropboxusercontent.com/s/07idzh820603obu/papaya.jpg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("mandarinas",2000,50,"mandarinas por unidad","https://dl.dropboxusercontent.com/s/2hrnpkarg0iczwp/mandarina.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("guanabanas",7000,25,"guanabanas por unidad","https://dl.dropboxusercontent.com/s/b0iuv6zy9z8nd3e/guanabana.jpeg?dl=0",1,1);
INSERT INTO PRODUCTO (nombre,precio,cantidad,descripcion, imagen,fkid_unidad,fkid_agrupacion) VALUES ("uvas",5500,25,"uvas por libra","https://dl.dropboxusercontent.com/s/dtffanruarx69m6/uvas.jpeg?dl=0",1,2);
