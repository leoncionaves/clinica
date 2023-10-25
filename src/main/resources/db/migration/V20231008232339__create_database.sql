CREATE TABLE profissionais (
	id bigint PRIMARY KEY NOT NULL,
	crm varchar(20),
	especialidade varchar(20),
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
	data_cadastro TIMESTAMP DEFAULT NOW()
);

CREATE SEQUENCE public.seq_profissional
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


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

CREATE SEQUENCE public.seq_paciente
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE agendamentos (
    id bigint PRIMARY KEY,
    id_paciente INT,
    id_profissional INT,
    data_agendamento DATE,
    hora_agendamento TIME,
    confirmada boolean DEFAULT FALSE,
    observacao TEXT,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_profissional) REFERENCES profissionais(id)
);

CREATE SEQUENCE public.seq_agendamento
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;