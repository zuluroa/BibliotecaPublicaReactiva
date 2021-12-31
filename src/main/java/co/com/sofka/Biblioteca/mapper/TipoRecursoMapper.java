package co.com.sofka.Biblioteca.mapper;


import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.model.TipoRecurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TipoRecursoMapper {

    public Function<TipoRecursoDTO, TipoRecurso> dtoToTipoRecurso(String id) {
        return updateTipoRecurso -> {
            var tipoRecurso = new TipoRecurso();
            tipoRecurso.setTipoRecursoId(id);
            tipoRecurso.setNombreTipoRecurso(updateTipoRecurso.getNombreTipoRecurso());
            return tipoRecurso;
        };
    }

    public Function<TipoRecurso, TipoRecursoDTO> TipoRecursoToDTO() {
        return entity -> new TipoRecursoDTO(entity.getTipoRecursoId(), entity.getNombreTipoRecurso());
    }
}
