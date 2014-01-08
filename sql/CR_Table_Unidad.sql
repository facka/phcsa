CREATE TABLE "Unidad"
(
  id_unidad bigint NOT NULL,
  numero integer,
  direccion_extendida text,
  id_edificio bigint,
  CONSTRAINT unidad_pk PRIMARY KEY (id_unidad),
  CONSTRAINT edificio_fk FOREIGN KEY (id_edificio)
      REFERENCES "Edificio" (id_edificio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


