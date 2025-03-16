package br.edu.ifpb.cartaxo.todo_list.controller;

import br.edu.ifpb.cartaxo.todo_list.model.Tarefa;
import br.edu.ifpb.cartaxo.todo_list.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TarefaController {

    @Autowired private TarefaService tarefaService;

    // Retorna todos os usuários
    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return this.tarefaService.getTarefas();
    }

    // Retorna um usuário a partir do id passado na URL
    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefaPorId(@PathVariable Long id) {
        return this.tarefaService.getTarefaPorId(id);
    }

    // Insere um novo usuário
    @PostMapping("/tarefas")
    public Tarefa inserirTarefa(@RequestBody Tarefa tarefa) {
        return this.tarefaService.inserirOuAtualizar(tarefa);
    }

    // Responde a requisições do tipo DELETE feitas para /api/users/{id}. Neste caso, irá remover o usuário cujo id for igual ao id passado na URL
    @DeleteMapping("tarefas/{id}")
    public void apagarTarefa(@PathVariable Long id) {
        this.tarefaService.apagar(id);
    }
}