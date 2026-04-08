# Projeto Carvalima — Site Institucional

## 📌 Sobre o Projeto

Site institucional do **Restaurante Carvalima**, desenvolvido como projeto de extensão da **UNINOVE — Universidade Nove de Julho**.

O objetivo é criar uma presença digital completa para o restaurante, com cardápio online, formulário de contato/reserva, informações de serviços e página institucional.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| **HTML5** | Estrutura semântica das páginas |
| **CSS3** | Estilização, animações, variáveis CSS, responsividade |
| **JavaScript (ES5/ES6)** | Interatividade: menu mobile, filtros, formulários, notificações |
| **IntersectionObserver API** | Animações ao rolar a página |

> ⚠️ Projeto **100% estático** — sem dependências externas de frameworks ou bibliotecas. Funciona abrindo os arquivos HTML diretamente no navegador ou servindo via qualquer servidor HTTP.

---

## 📂 Estrutura de Arquivos

```
carvalima/
└── public/
    ├── index.html          ← Página principal (Home)
    ├── sobre.html          ← Sobre o restaurante / equipe / valores
    ├── servicos.html       ← Serviços: salão, eventos, delivery, catering
    ├── cardapio.html       ← Cardápio completo com filtro por categoria
    ├── contato.html        ← Formulário de contato / reserva + FAQ
    ├── css/
    │   └── style.css       ← Stylesheet principal com variáveis CSS
    └── js/
        └── main.js         ← JavaScript: menu, filtros, formulário, animações
```

---

## 🗂️ Páginas

| Arquivo | Conteúdo |
|---|---|
| `index.html` | Hero, diferenciais, resumo da história, destaques do cardápio, depoimentos e CTA |
| `sobre.html` | História completa, números, equipe e valores da empresa |
| `servicos.html` | Restaurante, eventos, delivery, catering, marmitas, aulas + tabela de preços |
| `cardapio.html` | Cardápio filtrado por: Carnes, Aves, Acompanhamentos, Bebidas e Sobremesas |
| `contato.html` | Formulário inteligente, informações de contato, placeholder de mapa e FAQ |

---

## ⚙️ Funcionalidades JavaScript

- **Menu Hamburguer** — responsivo para dispositivos móveis
- **Filtro do Cardápio** — navegação por categoria com botões de abas
- **Formulário de Contato** — validação de campos, campos dinâmicos (data/pessoas) e simulação de envio
- **Notificações Flutuantes** — feedback visual de ações (ex.: promoção do dia, confirmação de envio)
- **Scroll Reveal** — animação suave ao entrar na viewport usando `IntersectionObserver`

---

## 🎨 Design

- **Paleta de cores**: laranja-tijolo (`#b5451b`) + dourado (`#f0a500`) + quase-preto (`#2c2c2c`)
- **Tipografia**: Georgia (títulos) + Arial (corpo)
- **Responsivo**: layout em grid adaptativo para mobile (< 600px), tablet e desktop
- **Variáveis CSS** para consistência e facilidade de manutenção

---

## 🖥️ Como Executar

### Opção 1 — Abrir diretamente no navegador
```
Abra o arquivo: carvalima/public/index.html
```

### Opção 2 — Servidor local simples (Python)
```bash
cd carvalima/public
python3 -m http.server 3000
# Acesse: http://localhost:3000
```

### Opção 3 — Live Server (VS Code)
Instale a extensão **Live Server** e clique com o botão direito em `index.html` → *Open with Live Server*.

---

## 📄 Autores

* Gabriell Silva França Lau — RA: 3025200966

UNINOVE – Universidade Nove de Julho  
Projeto de Extensão — 2024
