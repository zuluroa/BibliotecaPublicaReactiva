package co.com.sofka.Biblioteca.usecase.tiporecurso;

import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.mapper.TipoRecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioTipoRecurso;
import co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz.ConsultarTipoRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;


@Service
@Validated
public class ConsultarTipoRecursoUseCase implements ConsultarTipoRecurso {

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;


    public ConsultarTipoRecursoUseCase(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }

    @Override
    public Flux<TipoRecursoDTO> get() {
        return repositorioTipoRecurso.findAll().map(tipoRecursoMapper.TipoRecursoToDTO());
    }

}
