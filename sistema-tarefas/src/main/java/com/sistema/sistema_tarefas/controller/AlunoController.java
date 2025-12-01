package com.sistema.sistema_tarefas.controller;

import com.sistema.sistema_tarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final TarefaService tarefaService;

    // INJEÇÃO DE DEPENDÊNCIA (OBRIGATÓRIO)
    public AlunoController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public String listarTarefasAluno(Model model) {
        model.addAttribute("listaTarefas", tarefaService.listarTodas());
        return "aluno/tarefas";
    }
}
