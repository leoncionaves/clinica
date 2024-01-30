CREATE TABLE profissionais (
	id bigint PRIMARY KEY NOT NULL,
	registro_conselho varchar(20),
	email varchar(100),
	bairro varchar(100),
	cep varchar(10),
	cidade varchar(255),
	complemento varchar(150),
	logradouro varchar(255),
	numero varchar(10),
	uf varchar(2),
	nome varchar(100) not null,
	telefone varchar(20),
	ativo boolean DEFAULT TRUE NOT NULL,
	data_cadastro TIMESTAMP DEFAULT NOW()
);

CREATE TABLE pacientes (
    id bigint PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(255),
    logradouro VARCHAR(255),
    numero VARCHAR(20),
    complemento VARCHAR(255),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf CHAR(2),
    cep CHAR(8),
    data_nascimento DATE,
    sexo CHAR(1),
    data_cadastro TIMESTAMP DEFAULT NOW(),
    ativo boolean DEFAULT TRUE NOT NULL
);

CREATE TABLE agendamentos (
    id bigint PRIMARY KEY,
    id_paciente INT,
    id_profissional INT,
    data DATE,
    hora TIME,
    confirmada boolean DEFAULT FALSE,
    observacao TEXT,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_profissional) REFERENCES profissionais(id)
);

CREATE TABLE public.especialidades (
	id bigint NOT NULL,
	especialidade varchar NOT NULL,
	CONSTRAINT especialidades_pk PRIMARY KEY (id)
);



CREATE TABLE public.profissional_especialidade (
	id_profissional int4 NOT NULL,
	id_especialidade int4 NOT NULL,
	CONSTRAINT profissional_especialidade_pkey PRIMARY KEY (id_profissional, id_especialidade)
);
-- public.profissional_especialidade foreign keys
ALTER TABLE public.profissional_especialidade ADD CONSTRAINT profissional_especialidade_id_especialidade_fkey FOREIGN KEY (id_especialidade) REFERENCES public.especialidades(id);
ALTER TABLE public.profissional_especialidade ADD CONSTRAINT profissional_especialidade_id_profissional_fkey FOREIGN KEY (id_profissional) REFERENCES public.profissionais(id);

CREATE TABLE usuarios (
    id bigint PRIMARY KEY NOT NULL,
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

CREATE SEQUENCE public.seq_pessoa
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_especialidade
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE public.seq_agendamento
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;