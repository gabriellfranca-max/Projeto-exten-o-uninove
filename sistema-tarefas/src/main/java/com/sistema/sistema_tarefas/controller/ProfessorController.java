package com.sistema.sistema_tarefas.controller;

import com.sistema.sistema_tarefas.entity.Tarefa;
import com.sistema.sistema_tarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // SALVAR
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "redirect:/professor/tarefas";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("tarefa", tarefaService.buscarPorId(id));
        return "professor/form-tarefa";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return "redirect:/professor/tarefas";
    }

    
@GetMapping("/ping")
@ResponseBody
public String ping() {
    return "OK - Controller carregado!";
}

}
