package br.edu.ifpb.cartaxo.todo_list.service;

import br.edu.ifpb.cartaxo.todo_list.model.Tarefa;
import br.edu.ifpb.cartaxo.todo_list.repositories.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    // Injetando dependência do repositório
    @Autowired
    private TarefaRepository tarefaRepository;

    // Retorna todas as tarefas cadastradas
    public List<Tarefa> getTarefas() {
        return this.tarefaRepository.findAll();
    }

    // Busca uma tarefa por id
    public Tarefa getTarefaPorId(Long id) {
        return this.tarefaRepository.findById(id)
                .orElse(null);
    }

    // Adiciona uma nova tarefa
    @Transactional
    public Tarefa inserirTarefa(Tarefa tarefa) {
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty()) {
            // Lança exceção caso a tarefa que está sendo cadastrada não tenha título
            throw new RuntimeException("O título da tarefa é obrigatório");
        }

        // Se não lançar exceção, salva a tarefa
        return this.tarefaRepository.save(tarefa);
    }

    // Atualiza uma tarefa existente
    public Tarefa atualizarTarefa(Long id, Tarefa obj) {
        Tarefa tarefa = tarefaRepository.getReferenceById(id);
        tarefa.setTitulo(obj.getTitulo());
        tarefa.setCategoria(obj.getCategoria());
        tarefa.setConcluido(obj.getConcluido());

        return tarefaRepository.save(tarefa);
    }

    // Remove uma tarefa a partir de um id
    public void apagar(Long id) {
        this.tarefaRepository.deleteById(id);
    }
}