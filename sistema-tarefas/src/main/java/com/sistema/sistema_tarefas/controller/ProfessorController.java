package com.sistema.sistema_tarefas.controller;

import com.sistema.sistema_tarefas.entity.Tarefa;
import com.sistema.sistema_tarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/professor/tarefas")
public class ProfessorController {

    private final TarefaService tarefaService;

    public ProfessorController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaTarefas", tarefaService.listarTodas());
        return "professor/tarefas";
    }

    // FORM NOVA TAREFA
    @GetMapping("/nova")
    public String novaTarefa(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "professor/form-tarefa";
    }

    // SALVAR (CORRIGIDO)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Tarefa tarefa) {
        try {
            tarefaService.salvar(tarefa);
            return "redirect:/professor/tarefas";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/professor/tarefas/nova?error=true";
        }
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        if (tarefa == null) {
            return "redirect:/professor/tarefas";
        }
        model.addAttribute("tarefa", tarefa);
        return "professor/form-tarefa";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        try {
            tarefaService.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/professor/tarefas";
    }
}