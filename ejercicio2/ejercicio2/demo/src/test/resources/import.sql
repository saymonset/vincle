
INSERT INTO capacidad (id,nombre) VALUES (1,'100 gr');



INSERT INTO envases (id,nombre) VALUES (1,'Botella');
INSERT INTO envases (id,nombre) VALUES (2,'Caja');

INSERT INTO estados (id,nombre) VALUES (1,'WAITING');
INSERT INTO estados (id,nombre) VALUES (2,'CREATED');
INSERT INTO estados (id,nombre) VALUES (3,'DELETED');


INSERT INTO tipos (id,nombre) VALUES (1,'bebida');
INSERT INTO tipos (id,nombre) VALUES (2,'comida');
INSERT INTO tipos (id,nombre) VALUES (3,'salsas');
INSERT INTO tipos (id,nombre) VALUES (4,'especies');

INSERT INTO clientes (id,nombre) VALUES (1,'CocaCola');



INSERT INTO ITEMS (id, estado_id, tipo_id, capacidad_id, envase_id, identifidor, nom_cliente_id, nombre) values (9, 1, 2, 1, 2, 'identificador 98', 1, 'Nombre del item' );
  