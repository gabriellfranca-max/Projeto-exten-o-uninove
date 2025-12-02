package com.sistema.sistema_tarefas.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity

@Table(name = "tarefas")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Lob 
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_entrega") // Opcional: para nome de coluna no banco
    private LocalDate dataEntrega;
    
    // CONSTRUTOR VAZIO (IMPORTANTE!)
    public Tarefa() {
    }
    
    // CONSTRUTOR COM PARÂMETROS
    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
    }
}