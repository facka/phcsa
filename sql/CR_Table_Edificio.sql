-- Table: edificio

-- DROP TABLE edificio;

CREATE SEQUENCE edificio_idedificio_seq;

CREATE TABLE edificio
(
  id integer NOT NULL DEFAULT nextval('edificio_idedificio_seq'::regclass),
  direccion character varying(60) NOT NULL,
  CONSTRAINT edificio_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE edificio
  OWNER TO postgres;
  
ALTER SEQUENCE edificio_idedificio_seq OWNED BY edificio.id;