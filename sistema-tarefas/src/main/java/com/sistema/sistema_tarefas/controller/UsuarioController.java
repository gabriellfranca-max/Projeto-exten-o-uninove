package com.sistema.sistema_tarefas.controller;

import com.sistema.sistema_tarefas.entity.Usuario;
import com.sistema.sistema_tarefas.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    // MOSTRAR FORMULÁRIO DE CADASTRO
    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    // PROCESSAR CADASTRO
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        try {
            // Verificar se email já existe
            Usuario existente = usuarioService.buscarPorEmail(usuario.getEmail());
            if (existente != null) {
                model.addAttribute("mensagem", "Email já cadastrado!");
                model.addAttribute("usuario", usuario);
                return "cadastro";
            }
            
            // Criptografar senha
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            
            // Salvar usuário
            usuarioService.salvar(usuario);
            
            model.addAttribute("mensagem", "Cadastro realizado com sucesso! Faça login.");
            return "redirect:/login";
            
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao cadastrar: " + e.getMessage());
            model.addAttribute("usuario", usuario);
            return "cadastro";
        }
    }
}