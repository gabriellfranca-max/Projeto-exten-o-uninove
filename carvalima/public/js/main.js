/**
 * Carvalima — main.js
 * Interatividade do site: menu mobile, formulário de contato,
 * filtro do cardápio e notificações.
 */

// ──────────────────────────────────────────────
// 1. MENU MOBILE (hamburguer)
// ──────────────────────────────────────────────
(function initMenu() {
    const toggle = document.getElementById('menuToggle');
    const navLinks = document.getElementById('navLinks');
    if (!toggle || !navLinks) return;

    toggle.addEventListener('click', function () {
        navLinks.classList.toggle('aberto');
        const isOpen = navLinks.classList.contains('aberto');
        toggle.setAttribute('aria-expanded', isOpen);
    });

    // Fechar ao clicar em um link
    navLinks.querySelectorAll('a').forEach(function (link) {
        link.addEventListener('click', function () {
            navLinks.classList.remove('aberto');
        });
    });

    // Fechar ao clicar fora
    document.addEventListener('click', function (e) {
        if (!toggle.contains(e.target) && !navLinks.contains(e.target)) {
            navLinks.classList.remove('aberto');
        }
    });
}());

// ──────────────────────────────────────────────
// 2. NOTIFICAÇÃO FLUTUANTE (apenas na home)
// ──────────────────────────────────────────────
(function initNotificacao() {
    const notif = document.getElementById('notificacao');
    if (!notif || !notif.textContent.trim()) return;

    setTimeout(function () {
        notif.classList.add('visivel');

        setTimeout(function () {
            notif.classList.remove('visivel');
        }, 5000);
    }, 2500);
}());

// ──────────────────────────────────────────────
// 3. FORMULÁRIO DE CONTATO
// ──────────────────────────────────────────────
(function initFormContato() {
    var form = document.getElementById('formContato');
    if (!form) return;

    var assunto = document.getElementById('assunto');
    var grupoData = document.getElementById('grupoData');
    var grupoPessoas = document.getElementById('grupoPessoas');

    // Mostrar campos extras dependendo do assunto selecionado
    if (assunto) {
        assunto.addEventListener('change', function () {
            var val = assunto.value;
            var mostraExtra = val === 'reserva' || val === 'evento' || val === 'catering';
            grupoData.style.display = mostraExtra ? 'flex' : 'none';
            grupoPessoas.style.display = mostraExtra ? 'flex' : 'none';
        });
    }

    // Submissão do formulário
    form.addEventListener('submit', function (e) {
        e.preventDefault();

        // Validação básica
        var nome = document.getElementById('nome');
        var email = document.getElementById('email');
        var mensagem = document.getElementById('mensagem');
        var camposObrigatorios = [nome, email, mensagem];
        var valido = true;

        camposObrigatorios.forEach(function (campo) {
            if (!campo || !campo.value.trim()) {
                marcarErro(campo);
                valido = false;
            } else {
                limparErro(campo);
            }
        });

        // Validação de e-mail
        if (email && email.value && !validarEmail(email.value)) {
            marcarErro(email);
            valido = false;
        }

        if (!valido) {
            mostrarNotificacao('⚠️ Preencha todos os campos obrigatórios.', 'erro');
            return;
        }

        // Simular envio
        var btnSubmit = form.querySelector('button[type="submit"]');
        var textoOriginal = btnSubmit.textContent;
        btnSubmit.textContent = 'Enviando…';
        btnSubmit.disabled = true;

        setTimeout(function () {
            form.reset();
            btnSubmit.textContent = textoOriginal;
            btnSubmit.disabled = false;
            if (grupoData) grupoData.style.display = 'none';
            if (grupoPessoas) grupoPessoas.style.display = 'none';
            mostrarNotificacao('✅ Mensagem enviada! Entraremos em contato em breve.', 'sucesso');
        }, 1800);
    });

    function marcarErro(campo) {
        if (!campo) return;
        campo.style.borderColor = 'var(--cor-primaria)';
        campo.style.boxShadow = '0 0 0 3px rgba(181,69,27,0.2)';
    }

    function limparErro(campo) {
        if (!campo) return;
        campo.style.borderColor = '';
        campo.style.boxShadow = '';
    }

    function validarEmail(email) {
        return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    }
}());

// ──────────────────────────────────────────────
// 4. FILTRO DO CARDÁPIO
// ──────────────────────────────────────────────
(function initFiltroCardapio() {
    var filtroTabs = document.getElementById('filtroTabs');
    if (!filtroTabs) return;

    filtroTabs.querySelectorAll('.tab-btn').forEach(function (btn) {
        btn.addEventListener('click', function () {
            // Atualizar botões
            filtroTabs.querySelectorAll('.tab-btn').forEach(function (b) {
                b.classList.remove('ativo');
            });
            btn.classList.add('ativo');

            // Mostrar seção correspondente
            var secao = btn.getAttribute('data-secao');
            document.querySelectorAll('.secao-cardapio').forEach(function (s) {
                s.classList.remove('visivel');
            });
            var alvo = document.getElementById('secao-' + secao);
            if (alvo) {
                alvo.classList.add('visivel');
                alvo.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
            }
        });
    });
}());

// ──────────────────────────────────────────────
// 5. FUNÇÃO GLOBAL DE NOTIFICAÇÃO
// ──────────────────────────────────────────────
function mostrarNotificacao(mensagem, tipo) {
    var notif = document.getElementById('notificacao');
    if (!notif) {
        notif = document.createElement('div');
        notif.id = 'notificacao';
        notif.className = 'notificacao';
        document.body.appendChild(notif);
    }

    notif.textContent = mensagem;
    notif.style.backgroundColor = tipo === 'erro' ? '#c0392b' : 'var(--cor-primaria)';
    notif.classList.add('visivel');

    clearTimeout(notif._timer);
    notif._timer = setTimeout(function () {
        notif.classList.remove('visivel');
    }, 4000);
}

// ──────────────────────────────────────────────
// 6. ANIMAÇÃO SUAVE AO ENTRAR NA VIEWPORT
// ──────────────────────────────────────────────
(function initScrollReveal() {
    if (!window.IntersectionObserver) return;

    var elementos = document.querySelectorAll('.card, .item-cardapio, .item-cardapio-h, .stat-item, .equipe-card, .servico-card, .depoimento-card');

    elementos.forEach(function (el) {
        el.style.opacity = '0';
        el.style.transform = 'translateY(20px)';
        el.style.transition = 'opacity 0.5s ease, transform 0.5s ease';
    });

    var observer = new IntersectionObserver(function (entries) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
                observer.unobserve(entry.target);
            }
        });
    }, { threshold: 0.12 });

    elementos.forEach(function (el) {
        observer.observe(el);
    });
}());
