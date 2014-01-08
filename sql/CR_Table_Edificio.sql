- Table: edificio

-- DROP TABLE edificio;

CREATE TABLE edificio
(
  id integer NOT NULL DEFAULT nextval('edificio_idedificio_seq'::regclass),
  direccion character varying(60) NOT NULL,
  CONSTRAINT edificio_pkey PRIMARY KEY (id)
)


