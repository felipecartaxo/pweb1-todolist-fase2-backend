package br.edu.ifpb.cartaxo.todo_list.repositories;

import br.edu.ifpb.cartaxo.todo_list.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // --------- Consultas personalizadas ---------

    // Buscar tarefa(s) a partir de um título específico
    public List<Tarefa> findByTitulo(String titulo);

    // Buscar apenas as tarefas concluídas
    @Query("SELECT t FROM Tarefa t where t.concluido=true")
    public List<Tarefa> findByConcluido();

    // Buscar as tarefas de uma determinada categoria
    public List<Tarefa> findByCategoria(String categoria);
}