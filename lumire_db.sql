-- =========================================================
-- Banco de Dados: Plataforma Lumière
-- Cobre: RF.001 (Cadastro de Filme) e RF.002 (Cadastro de Usuário)
-- =========================================================

-- 1. Criação do Banco de Dados (Schema) caso ele não exista
CREATE DATABASE IF NOT EXISTS lumiere_db;

-- 2. Aponta para o banco que utilizaremos a partir de agora
USE lumiere_db;

-- 3. Tabela de Filmes (RF.001)
-- Critérios de Aceitação atendidos:
--   - título, gênero, duração e ano de lançamento (colunas)
--   - impedir cadastro duplicado de mesmo título + ano (UNIQUE composta)
--   - duração maior que zero (CHECK)
CREATE TABLE IF NOT EXISTS filme (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo          VARCHAR(255) NOT NULL,
    genero          VARCHAR(100) NOT NULL,
    duracao_min     INT NOT NULL,
    ano_lancamento  YEAR NOT NULL,
    CONSTRAINT uq_filme_titulo_ano UNIQUE (titulo, ano_lancamento),
    CONSTRAINT chk_filme_duracao CHECK (duracao_min > 0)
);

-- 4. Tabela de Usuários (RF.002)
-- Critérios de Aceitação atendidos:
--   - nome, e-mail e senha (colunas)
--   - e-mail não pode se repetir (UNIQUE)
--   - senha com no mínimo 8 caracteres (CHECK; ver observação abaixo)
CREATE TABLE IF NOT EXISTS usuario (
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
    senha   VARCHAR(255) NOT NULL,
    CONSTRAINT uq_usuario_email UNIQUE (email),
    CONSTRAINT chk_usuario_senha_tamanho CHECK (CHAR_LENGTH(senha) >= 8)
);