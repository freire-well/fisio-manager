# API Documentation - Backend (localhost:8080)

## Visão Geral
Este documento descreve as rotas que seu backend deve implementar para funcionar com o Gestor de Fisioterapia.

**Base URL:** `http://localhost:8080/api`

---

## 📅 Agendamentos

### GET /api/agendamentos
Retorna todos os agendamentos.

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "patient": "Maria Silva",
    "patientId": 1,
    "date": "2026-02-09",
    "time": "09:00",
    "type": "Consulta"
  },
  {
    "id": 2,
    "patient": "João Santos",
    "patientId": 2,
    "date": "2026-02-09",
    "time": "14:00",
    "type": "Retorno"
  }
]
```

---

### POST /api/agendamentos
Cria um novo agendamento.

**Request Body:**
```json
{
  "patient": "Ana Costa",
  "patientId": 3,
  "date": "2026-02-10",
  "time": "10:00",
  "type": "Avaliação"
}
```

**Response (201 Created):**
```json
{
  "id": 3,
  "patient": "Ana Costa",
  "patientId": 3,
  "date": "2026-02-10",
  "time": "10:00",
  "type": "Avaliação"
}
```

---

### DELETE /api/agendamentos/{id}
Remove um agendamento específico.

**URL Parameters:**
- `id` - ID do agendamento

**Response (200 OK):**
```json
{
  "message": "Agendamento removido com sucesso"
}
```

**Response (404 Not Found):**
```json
{
  "error": "Agendamento não encontrado"
}
```

---

## 👥 Pacientes

### GET /api/pacientes
Retorna todos os pacientes cadastrados.

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Maria Silva",
    "dataNascimento": "1985-03-15",
    "telefone": "(11) 98765-4321",
    "email": "maria.silva@email.com"
  },
  {
    "id": 2,
    "nome": "João Santos",
    "dataNascimento": "1990-07-22",
    "telefone": "(11) 91234-5678",
    "email": "joao.santos@email.com"
  }
]
```

---

### GET /api/pacientes/buscar?nome={nome}
Busca um paciente por nome.

**Query Parameters:**
- `nome` - Nome do paciente (pode ser parcial)

**Response (200 OK):**
```json
{
  "id": 1,
  "nome": "Maria Silva",
  "dataNascimento": "1985-03-15",
  "telefone": "(11) 98765-4321",
  "email": "maria.silva@email.com"
}
```

**Response (404 Not Found):**
```json
{
  "error": "Paciente não encontrado"
}
```

---

## 📋 Prontuários

### GET /api/prontuarios/{patientId}
Retorna o prontuário de um paciente específico.

**URL Parameters:**
- `patientId` - ID do paciente

**Response (200 OK):**
```json
{
  "patientId": 1,
  "nomeCompleto": "Maria Silva",
  "dataNascimento": "1985-03-15",
  "idade": "41",
  "sexo": "Feminino",
  "profissao": "Professora",
  "telefone": "(11) 98765-4321",
  "endereco": "Rua das Flores, 123 - São Paulo",
  "antecedentes": "Hipertensão controlada",
  "medicamentos": "Losartana 50mg",
  "cirurgias": "Apendicectomia (2010)",
  "queixaPrincipal": "Dor lombar",
  "inicioSintomas": "Há 2 meses",
  "fatoresAgravantes": "Ficar muito tempo sentada",
  "fatoresAtenuantes": "Repouso e alongamento",
  "inspecao": "Postura antálgica à esquerda",
  "palpacao": "Espasmo muscular em região lombar",
  "adm": "Flexão lombar limitada em 60%",
  "forcaMuscular": "Grau 4/5 em abdominais",
  "testesEspeciais": "Teste de Lasègue positivo à esquerda",
  "diagnostico": "Lombalgia mecânica com contratura muscular",
  "objetivosCurto": "Reduzir dor em 50% (2 semanas)",
  "objetivosMedio": "Recuperar ADM completa (1 mês)",
  "objetivosLongo": "Retornar às atividades normais (2 meses)",
  "condutas": "TENS, alongamento, fortalecimento",
  "tecnicas": "TENS, massagem relaxante, mobilização",
  "exercicios": "Williams, prancha, bird dog",
  "orientacoes": "Ergonomia no trabalho, pausas a cada 50min",
  "frequencia": "3x por semana",
  "assinatura": "Dr. João Fisioterapeuta",
  "crefito": "CREFITO-3/123456-F",
  "sessoes": [
    {
      "data": "2026-02-09",
      "horario": "09:00",
      "procedimentos": "TENS + alongamento",
      "evolucao": "Paciente relata melhora de 30% da dor",
      "valor": "R$ 150,00",
      "pagamento": "Pago"
    },
    {
      "data": "2026-02-11",
      "horario": "09:00",
      "procedimentos": "Massagem + exercícios",
      "evolucao": "Melhora progressiva, menos espasmo",
      "valor": "R$ 150,00",
      "pagamento": "Pendente"
    }
  ]
}
```

**Response (404 Not Found):**
```json
{
  "error": "Prontuário não encontrado"
}
```

---

### PUT /api/prontuarios/{patientId}
Atualiza ou cria o prontuário de um paciente.

**URL Parameters:**
- `patientId` - ID do paciente

**Request Body:**
```json
{
  "patientId": 1,
  "nomeCompleto": "Maria Silva",
  "dataNascimento": "1985-03-15",
  "idade": "41",
  "sexo": "Feminino",
  "profissao": "Professora",
  "telefone": "(11) 98765-4321",
  "endereco": "Rua das Flores, 123 - São Paulo",
  "antecedentes": "Hipertensão controlada",
  "medicamentos": "Losartana 50mg",
  "cirurgias": "Apendicectomia (2010)",
  "queixaPrincipal": "Dor lombar",
  "inicioSintomas": "Há 2 meses",
  "fatoresAgravantes": "Ficar muito tempo sentada",
  "fatoresAtenuantes": "Repouso e alongamento",
  "inspecao": "Postura antálgica à esquerda",
  "palpacao": "Espasmo muscular em região lombar",
  "adm": "Flexão lombar limitada em 60%",
  "forcaMuscular": "Grau 4/5 em abdominais",
  "testesEspeciais": "Teste de Lasègue positivo à esquerda",
  "diagnostico": "Lombalgia mecânica com contratura muscular",
  "objetivosCurto": "Reduzir dor em 50% (2 semanas)",
  "objetivosMedio": "Recuperar ADM completa (1 mês)",
  "objetivosLongo": "Retornar às atividades normais (2 meses)",
  "condutas": "TENS, alongamento, fortalecimento",
  "tecnicas": "TENS, massagem relaxante, mobilização",
  "exercicios": "Williams, prancha, bird dog",
  "orientacoes": "Ergonomia no trabalho, pausas a cada 50min",
  "frequencia": "3x por semana",
  "assinatura": "Dr. João Fisioterapeuta",
  "crefito": "CREFITO-3/123456-F",
  "sessoes": [...]
}
```

**Response (200 OK):**
```json
{
  "message": "Prontuário salvo com sucesso",
  "data": { ... }
}
```

---

## 🔧 Configuração CORS

O backend deve habilitar CORS para permitir requisições do frontend:

```javascript
// Exemplo em Node.js/Express
app.use(cors({
  origin: '*',
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
  allowedHeaders: ['Content-Type']
}));
```

```java
// Exemplo em Spring Boot
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FisioterapiaController {
    // ...
}
```

---

## 📝 Notas Importantes

1. **Tratamento de Erros**: Todas as rotas devem retornar códigos HTTP apropriados (200, 201, 404, 500, etc.)

2. **Validação**: O backend deve validar os dados recebidos antes de processar

3. **IDs**: Os IDs devem ser únicos e preferencialmente auto-incrementados

4. **Fallback**: O frontend possui fallback local se a API não estiver disponível

5. **Banco de Dados**: Recomenda-se usar PostgreSQL, MySQL ou MongoDB para persistência

---

## 🚀 Exemplo de Implementação (Node.js/Express)

```javascript
const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(express.json());

// GET /api/agendamentos
app.get('/api/agendamentos', (req, res) => {
  // Buscar do banco de dados
  res.json([...]);
});

// POST /api/agendamentos
app.post('/api/agendamentos', (req, res) => {
  // Salvar no banco de dados
  res.status(201).json(req.body);
});

// DELETE /api/agendamentos/:id
app.delete('/api/agendamentos/:id', (req, res) => {
  // Remover do banco de dados
  res.json({ message: 'Agendamento removido' });
});

// GET /api/prontuarios/:patientId
app.get('/api/prontuarios/:patientId', (req, res) => {
  // Buscar prontuário do banco
  res.json({...});
});

// PUT /api/prontuarios/:patientId
app.put('/api/prontuarios/:patientId', (req, res) => {
  // Salvar/atualizar prontuário
  res.json({ message: 'Prontuário salvo' });
});

app.listen(8080, () => {
  console.log('API rodando em http://localhost:8080');
});
```

---

## 📊 Estrutura de Banco de Dados Sugerida

### Tabela: pacientes
```sql
CREATE TABLE pacientes (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  data_nascimento DATE,
  telefone VARCHAR(20),
  email VARCHAR(255)
);
```

### Tabela: agendamentos
```sql
CREATE TABLE agendamentos (
  id SERIAL PRIMARY KEY,
  patient_id INTEGER REFERENCES pacientes(id),
  patient VARCHAR(255),
  date DATE NOT NULL,
  time TIME NOT NULL,
  type VARCHAR(50)
);
```

### Tabela: prontuarios
```sql
CREATE TABLE prontuarios (
  id SERIAL PRIMARY KEY,
  patient_id INTEGER REFERENCES pacientes(id) UNIQUE,
  nome_completo VARCHAR(255),
  data_nascimento DATE,
  idade VARCHAR(10),
  sexo VARCHAR(20),
  profissao VARCHAR(100),
  telefone VARCHAR(20),
  endereco TEXT,
  antecedentes TEXT,
  medicamentos TEXT,
  cirurgias TEXT,
  queixa_principal TEXT,
  inicio_sintomas VARCHAR(255),
  fatores_agravantes TEXT,
  fatores_atenuantes TEXT,
  inspecao TEXT,
  palpacao TEXT,
  adm TEXT,
  forca_muscular TEXT,
  testes_especiais TEXT,
  diagnostico TEXT,
  objetivos_curto TEXT,
  objetivos_medio TEXT,
  objetivos_longo TEXT,
  condutas TEXT,
  tecnicas TEXT,
  exercicios TEXT,
  orientacoes TEXT,
  frequencia VARCHAR(100),
  assinatura VARCHAR(255),
  crefito VARCHAR(50)
);
```

### Tabela: sessoes
```sql
CREATE TABLE sessoes (
  id SERIAL PRIMARY KEY,
  prontuario_id INTEGER REFERENCES prontuarios(id),
  data DATE,
  horario TIME,
  procedimentos TEXT,
  evolucao TEXT,
  valor VARCHAR(50),
  pagamento VARCHAR(50)
);
```
