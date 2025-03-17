package br.edu.ifpb.cartaxo.todo_list.controller;

import br.edu.ifpb.cartaxo.todo_list.model.Tarefa;
import br.edu.ifpb.cartaxo.todo_list.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TarefaController {

    @Autowired private TarefaService tarefaService;

    // Retorna todos as tarefas
    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return this.tarefaService.getTarefas();
    }

    // Retorna uma tarefa a partir do id passado na URL
    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefaPorId(@PathVariable Long id) {
        return this.tarefaService.getTarefaPorId(id);
    }

    // Insere uma nova tarefa
    @PostMapping("/tarefas")
    public Tarefa inserirTarefa(@RequestBody Tarefa tarefa) {
        return this.tarefaService.inserirTarefa(tarefa);
    }

    // Atualiza uma tarefa existente
    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa = tarefaService.atualizarTarefa(id, tarefa);

        return ResponseEntity.ok().body(tarefa);
    }

    // Responde a requisições do tipo DELETE feitas para tarefas/{id}. Neste caso, irá remover a tarefa cujo id for igual ao id passado na URL
    @DeleteMapping("tarefas/{id}")
    public void apagarTarefa(@PathVariable Long id) {
        this.tarefaService.apagar(id);
    }
}