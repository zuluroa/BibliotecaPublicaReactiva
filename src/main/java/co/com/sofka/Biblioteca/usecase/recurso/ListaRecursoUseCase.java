package co.com.sofka.Biblioteca.usecase.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import co.com.sofka.Biblioteca.usecase.recurso.interfaz.ListaRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class ListaRecursoUseCase implements ListaRecurso {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public ListaRecursoUseCase(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repositorioRecurso.findAll().map(recursoMapper.RecursoToDTO());
    }
}
