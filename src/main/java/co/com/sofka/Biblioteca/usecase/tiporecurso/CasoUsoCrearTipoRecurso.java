package co.com.sofka.Biblioteca.usecase.tiporecurso;

import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.mapper.TipoRecursoMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioTipoRecurso;
import co.com.sofka.Biblioteca.usecase.tiporecurso.interfaz.CrearTipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CasoUsoCrearTipoRecurso implements CrearTipoServicio {

    private final RepositorioTipoRecurso repositorioTipoRecurso;
    private final TipoRecursoMapper tipoRecursoMapper;

    @Autowired
    public CasoUsoCrearTipoRecurso(RepositorioTipoRecurso repositorioTipoRecurso, TipoRecursoMapper tipoRecursoMapper) {
        this.repositorioTipoRecurso = repositorioTipoRecurso;
        this.tipoRecursoMapper = tipoRecursoMapper;
    }


    @Override
    public Mono<TipoRecursoDTO> save(TipoRecursoDTO tipoRecursoDTO) {
        return repositorioTipoRecurso
                .save(tipoRecursoMapper.dtoToTipoRecurso(null).apply(tipoRecursoDTO))
                .map(tipoRecursoMapper.TipoRecursoToDTO());
    }
}
