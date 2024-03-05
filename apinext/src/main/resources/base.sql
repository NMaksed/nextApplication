DROP
DATABASE IF EXISTS nextData;
CREATE
DATABASE IF NOT EXISTS nextData;
USE
nextData;

CREATE TABLE `pessoa`
(
    `id`             integer PRIMARY KEY AUTO_INCREMENT,
    `nome`           varchar(255) NOT NULL,
    `cpf`            varchar(255) NOT NULL,
    `rg`             varchar(255) NOT NULL,
    `telefone`       varchar(255),
    `cep`            varchar(255) NOT NULL,
    `data_nascimento` date         NOT NULL
);

CREATE TABLE `funcionario`
(
    `id`        integer PRIMARY KEY AUTO_INCREMENT,
    `salario` double NOT NULL,
    `pagamento` date    NOT NULL,
    `pessoa_id` integer NOT NULL
);

CREATE TABLE `usuario`
(
    `id`             integer PRIMARY KEY AUTO_INCREMENT,
    `email`          varchar(255) NOT NULL,
    `senha`          varchar(255) NOT NULL,
    `funcionario_id` integer      NOT NULL,
    `role_id`        integer
);

CREATE TABLE `roles`
(
    `id`        integer PRIMARY KEY AUTO_INCREMENT,
    `role`      varchar(255),
    `descricao` varchar(255) NOT NULL
);

CREATE TABLE `aluno`
(
    `id`             integer PRIMARY KEY AUTO_INCREMENT,
    `plano`          varchar(255),
    `vencimento`     date,
    `vencido`        bit,
    `observacao`     longtext,
    `data_cadastro`   date,
    `email`          varchar(255),
    `plano_mutavel`  varchar(255),
    `pessoa_id`      integer NOT NULL,
    `agendamento_id` integer
);

CREATE TABLE `agendamento`
(
    `id`                 integer PRIMARY KEY AUTO_INCREMENT,
    `dia_aula`            varchar(255),
    `dias_treino`         varchar(255),
    `horario_agendamento` time NOT NULL
);

CREATE TABLE `aluno_agendamento`
(
    `id`             integer PRIMARY KEY AUTO_INCREMENT,
    `aluno_id`       integer,
    `agendamento_id` integer
);



ALTER TABLE funcionario
    ADD FOREIGN KEY (pessoa_id)
        REFERENCES pessoa (`id`);

ALTER TABLE usuario
    ADD FOREIGN KEY (funcionario_id)
        REFERENCES funcionario (`id`);

ALTER TABLE usuario
    ADD FOREIGN KEY (role_id)
        REFERENCES roles (`id`);

ALTER TABLE aluno
    ADD FOREIGN KEY (pessoa_id)
        REFERENCES pessoa (`id`);

ALTER TABLE aluno
    ADD FOREIGN KEY (agendamento_id)
        REFERENCES agendamento (`id`);

ALTER TABLE aluno_agendamento
    ADD FOREIGN KEY (aluno_id)
        REFERENCES aluno (`id`);

ALTER TABLE aluno_agendamento
    ADD FOREIGN KEY (agendamento_id)
        REFERENCES agendamento (`id`);

INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('João Silva', '123.456.789-01', '9876543', '12345-678', '11996378978', '1990-01-15');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Maria Oliveira', '987.654.321-02', '1234567', '54321-876', '11996378978', '1985-05-20');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Carlos Santos', '111.222.333-44', '8765432', '98765-432', '11996378978', '1995-08-10');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Ana Souza', '555.444.333-22', '6543210', '87654-321', '11996378978', '1980-12-05');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Fernando Pereira', '999.888.777-55', '9876541', '12345-678', '11996378978', '1992-03-25');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Aline Lima', '333.222.111-00', '1234569', '54321-876', '11996378978', '1988-07-18');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Rodrigo Oliveira', '777.666.555-33', '8765434', '98765-432', '11996378978', '1997-01-30');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Cristina Costa', '444.555.666-88', '6543212', '87654-321', '11996378978', '1983-09-08');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Lucas Martins', '222.333.444-11', '9876540', '12345-678', '11996378978', '1994-06-12');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Renata Pereira', '888.777.999-66', '1234568', '54321-876', '11996378978', '1987-04-03');
INSERT INTO pessoa (nome, cpf, rg, cep, telefone, data_nascimento) VALUES
    ('Nathan Grecco', '474.778.088-20', '501504242', '08820380', '11996378978', '2004-06-11');
INSERT INTO funcionario (salario, pagamento, pessoa_id) VALUES
    (5000.00, '2024-01-15', 1);
INSERT INTO funcionario (salario, pagamento, pessoa_id) VALUES
    (6000.00, '2024-02-20', 2);
INSERT INTO funcionario (salario, pagamento, pessoa_id) VALUES
    (5500.00, '2024-01-10', 3);
INSERT INTO funcionario (salario, pagamento, pessoa_id) VALUES
    (7000.00, '2024-03-25', 4);
INSERT INTO funcionario (salario, pagamento, pessoa_id) VALUES
    (7000.00, '2024-03-25', 11);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('MENSAL_2X', '2024-01-31', false, 'Sem observações', '2024-01-01', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 5);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('MENSAL_3X', '2024-02-15', true, 'Pagamento atrasado', '2024-01-01', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 6);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('MENSAL_5X', '2024-01-05', false, 'Com desconto especial', '2024-01-05', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 7);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('ANUAL_2X', '2024-03-20', false, 'Sem observações', '2024-01-03', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 8);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('ANUAL_3X', '2024-02-28', true, 'Pagamento atrasado', '2024-01-02', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 9);
INSERT INTO aluno (plano, vencimento, vencido, observacao, data_cadastro, email, plano_mutavel, pessoa_id) VALUES
    ('ANUAL_5X', '2024-04-10', false, 'Com desconto especial', '2024-01-01', 'nathangfonseca@hotmail.com', 'ANUAL_5X', 10);
INSERT INTO usuario (email, senha, funcionario_id) VALUES('nathangfonseca@hotmail.com', 'receba', 5);


