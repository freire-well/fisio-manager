-- Script SQL para criar a tabela de horários bloqueados
-- Execute isto no seu banco de dados

CREATE TABLE horarios_bloqueados (
    id SERIAL PRIMARY KEY,
    date VARCHAR(10) NOT NULL,
    time VARCHAR(5) NOT NULL,
    CONSTRAINT unique_date_time UNIQUE (date, time)
);

-- Índice para melhorar performance ao buscar por data
CREATE INDEX idx_horarios_bloqueados_date ON horarios_bloqueados(date);
