-- Table: unidad

-- DROP TABLE unidad;

CREATE SEQUENCE unidad_idunidad_seq;

CREATE TABLE unidad
(
  id integer NOT NULL DEFAULT nextval('unidad_idunidad_seq'::regclass),
  numero integer,
  direccion_extendida character varying(120),
  idedificio integer NOT NULL,
  CONSTRAINT unidad_pkey PRIMARY KEY (id),
  CONSTRAINT eidificio_fk FOREIGN KEY (idedificio)
      REFERENCES edificio (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE unidad
  OWNER TO postgres;

-- Index: fki_eidificio_fk

-- DROP INDEX fki_eidificio_fk;

CREATE INDEX fki_eidificio_fk
  ON unidad
  USING btree
  (idedificio);

ALTER SEQUENCE unidad_idunidad_seq OWNED BY unidad.id;