package com.kaikechaves.todolistapi.service;

import com.kaikechaves.todolistapi.exception.TarefaNotFoundException;
import com.kaikechaves.todolistapi.model.Tarefa;
import com.kaikechaves.todolistapi.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    private Tarefa tarefa;

    @BeforeEach
    void setUp() {
        tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Estudar Spring Boot");
        tarefa.setDescricao("Terminar a etapa de testes");
        tarefa.setConcluida(false);
    }

    @Test
    void deveCriarUmaTarefa() {
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa resultado = tarefaService.criar(tarefa);

        assertNotNull(resultado);
        assertEquals("Estudar Spring Boot", resultado.getTitulo());
        verify(tarefaRepository, times(1)).save(tarefa);
    }

    @Test
    void deveListarTodasAsTarefas() {
        when(tarefaRepository.findAll()).thenReturn(List.of(tarefa));

        List<Tarefa> resultado = tarefaService.listarTodas();

        assertEquals(1, resultado.size());
        verify(tarefaRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarTarefaPorIdQuandoExiste() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        Tarefa resultado = tarefaService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
        assertEquals("Estudar Spring Boot", resultado.getTitulo());
    }

    @Test
    void deveLancarExcecaoQuandoTarefaNaoExiste() {
        when(tarefaRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(TarefaNotFoundException.class, () -> {
            tarefaService.buscarPorId(999L);
        });
    }

    @Test
    void deveMarcarTarefaComoConcluida() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa resultado = tarefaService.marcarComoConcluida(1L);

        assertTrue(resultado.isConcluida());
    }

    @Test
    void deveExcluirTarefaQuandoExiste() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        tarefaService.excluir(1L);

        verify(tarefaRepository, times(1)).delete(tarefa);
    }
}
