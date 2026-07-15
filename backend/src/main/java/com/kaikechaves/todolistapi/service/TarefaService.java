package com.kaikechaves.todolistapi.service;

import com.kaikechaves.todolistapi.exception.TarefaNotFoundException;
import com.kaikechaves.todolistapi.model.Tarefa;
import com.kaikechaves.todolistapi.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new TarefaNotFoundException(id));
    }

    public Tarefa atualizar(Long Id, Tarefa tarefaAtualizada) {
        Tarefa tarefa = buscarPorId(Id);
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setDataLimite(tarefaAtualizada.getDataLimite());
        return tarefaRepository.save(tarefa);
    }

    public Tarefa marcarComoConcluida(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setConcluida(true);
        return tarefaRepository.save(tarefa);
    }

    public void excluir(Long Id) {
        Tarefa tarefa = buscarPorId(Id);
        tarefaRepository.delete(tarefa);
    }
}
