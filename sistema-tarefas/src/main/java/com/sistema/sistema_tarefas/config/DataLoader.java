package com.sistema.sistema_tarefas.config;

import com.sistema.sistema_tarefas.entity.Usuario;
import com.sistema.sistema_tarefas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository) {
        return args -> {
            BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

            // PROFESSOR
            String profEmail = "professor@sistema.com";
            if (usuarioRepository.findByEmail(profEmail) == null) {
                Usuario prof = new Usuario();
                prof.setNome("Professor Inicial");
                prof.setEmail(profEmail);
                prof.setSenha(enc.encode("1234")); // senha: 1234
                prof.setTipo("professor");
                usuarioRepository.save(prof);
                System.out.println("<<< Usuario professor criado: " + profEmail + " / 1234 >>>");
            } else {
                System.out.println("<<< professor já existe: " + profEmail + " >>>");
            }

            // ALUNO
            String alunoEmail = "aluno@sistema.com";
            if (usuarioRepository.findByEmail(alunoEmail) == null) {
                Usuario aluno = new Usuario();
                aluno.setNome("Aluno Inicial");
                aluno.setEmail(alunoEmail);
                aluno.setSenha(enc.encode("1234")); // senha: 1234
                aluno.setTipo("aluno");
                usuarioRepository.save(aluno);
                System.out.println("<<< Usuario aluno criado: " + alunoEmail + " / 1234 >>>");
            } else {
                System.out.println("<<< aluno já existe: " + alunoEmail + " >>>");
            }
        };
    }
}
