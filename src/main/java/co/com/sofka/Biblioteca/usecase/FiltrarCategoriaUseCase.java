package co.com.sofka.Biblioteca.usecase;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class FiltrarCategoriaUseCase {

    private final RepositorioRecurso repositorioRecurso;
    private final RecursoMapper recursoMapper;

    public FiltrarCategoriaUseCase(RepositorioRecurso repositorioRecurso, RecursoMapper recursoMapper) {
        this.repositorioRecurso = repositorioRecurso;
        this.recursoMapper = recursoMapper;
    }

    public Flux<RecursoDTO> filtrarCategoria(String id) {
        return repositorioRecurso.findRecursoBycategoriaId(id).map(recursoMapper.RecursoToDTO());
    }
}