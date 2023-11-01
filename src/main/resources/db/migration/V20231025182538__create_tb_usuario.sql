 CREATE TABLE usuarios (
	id_usuario bigint PRIMARY KEY NOT NULL,
	email varchar(100),
	bairro varchar(100),
	cep varchar(10),
	cidade varchar(255),
	complemento varchar(150),
	logradouro varchar(255),
	numero varchar(10),
	uf varchar(2),
	nome varchar(100),
	telefone varchar(20),
	ativo boolean DEFAULT TRUE NOT NULL,
	data_cadastro TIMESTAMP DEFAULT NOW(),
	usuario VARCHAR(100) NOT NULL UNIQUE,
	senha   VARCHAR(100) NOT NULL,
	role varchar (50) NOT NULL
);

CREATE SEQUENCE public.seq_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;