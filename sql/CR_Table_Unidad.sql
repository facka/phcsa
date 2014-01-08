-- Table: unidad

-- DROP TABLE unidad;

CREATE TABLE unidad
(
  id integer NOT NULL DEFAULT nextval('unidad_idunidad_seq'::regclass),
  numero integer,
  direccion_extendida character varying(120),
  idedificio integer NOT NULL DEFAULT nextval('"unidad_idUnidad_seq"'::regclass),
  CONSTRAINT unidad_pkey PRIMARY KEY (id),
  CONSTRAINT eidificio_fk FOREIGN KEY (idedificio)
      REFERENCES edificio (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

-- Index: fki_eidificio_fk

-- DROP INDEX fki_eidificio_fk;

CREATE INDEX fki_eidificio_fk
  ON unidad
  USING btree
  (idedificio);
