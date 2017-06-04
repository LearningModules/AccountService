-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
  bookid integer NOT NULL DEFAULT nextval('book_bookid_seq'::regclass),
  author character varying(255),
  genre_s character varying(255),
  instock boolean,
  name character varying(255),
  pages_i integer,
  price real,
  sequence_i character varying(255),
  series_t character varying(255),
  CONSTRAINT book_pkey PRIMARY KEY (bookid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO application;
