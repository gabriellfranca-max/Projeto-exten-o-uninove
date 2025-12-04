-- ======================================================
-- ESQUEMA DO BANCO: sistema_tarefas
-- Projeto: Sistema de Gerenciamento de Tarefas - UNINOVE
-- Disciplina: [Nome da Disciplina]
-- Data: 02/12/2025
-- 
-- IMPORTANTE: Este arquivo contém APENAS a estrutura
--             NÃO contém dados ou informações sensíveis
-- ======================================================

-- Criação do banco de dados (se não existir)
CREATE DATABASE IF NOT EXISTS sistema_tarefas 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE sistema_tarefas;

-- ------------------------------------------------------------
-- TABELA: usuarios
-- Finalidade: Armazenar os usuários do sistema
--             (professores e alunos)
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL COMMENT 'Nome completo do usuário',
    email VARCHAR(100) NOT NULL COMMENT 'E-mail único para login',
    senha VARCHAR(255) NOT NULL COMMENT 'Senha criptografada com BCrypt',
    tipo VARCHAR(20) NOT NULL COMMENT 'Tipo: professor ou aluno',
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_email (email),
    INDEX idx_tipo (tipo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ------------------------------------------------------------
-- TABELA: tarefas
-- Finalidade: Armazenar as tarefas educacionais
--             criadas pelos professores
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS tarefas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL COMMENT 'Título da tarefa',
    descricao TEXT COMMENT 'Descrição detalhada da tarefa',
    data_entrega DATE COMMENT 'Data limite para entrega',
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_data_entrega (data_entrega)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ------------------------------------------------------------
-- COMENTÁRIOS ADICIONAIS PARA DOCUMENTAÇÃO
-- ------------------------------------------------------------
ALTER TABLE usuarios 
COMMENT = 'Armazena os usuários do sistema (professores e alunos) com autenticação segura';

ALTER TABLE tarefas 
COMMENT = 'Armazena as tarefas educacionais atribuídas pelos professores';

-- ------------------------------------------------------------
-- VIEW: vw_tarefas_proximas (OPCIONAL - para relatórios)
-- ------------------------------------------------------------
CREATE OR REPLACE VIEW vw_tarefas_proximas AS
SELECT 
    id,
    titulo,
    data_entrega,
    DATEDIFF(data_entrega, CURDATE()) AS dias_para_entrega
FROM tarefas
WHERE data_entrega >= CURDATE()
ORDER BY data_entrega ASC;

-- ------------------------------------------------------------
-- USUÁRIO DO BANCO (OPCIONAL - para produção)
-- ------------------------------------------------------------
-- CREATE USER IF NOT EXISTS 'app_tarefas'@'localhost' 
-- IDENTIFIED BY 'senha_forte_aqui';
-- GRANT SELECT, INSERT, UPDATE, DELETE ON sistema_tarefas.* 
-- TO 'app_tarefas'@'localhost';
-- FLUSH PRIVILEGES;

-- ------------------------------------------------------------
-- FIM DO SCRIPT
-- Para executar: mysql -u root -p < database/schema.sql
-- ------------------------------------------------------------