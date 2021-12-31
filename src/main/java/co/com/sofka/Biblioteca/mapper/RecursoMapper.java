package co.com.sofka.Biblioteca.mapper;


import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.model.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {

    public Function<RecursoDTO, Recurso> dtoToRecurso() {
        return updateDato -> {
            var recurso = new Recurso();
            recurso.setId(updateDato.getId());
            recurso.setNombreRecurso(updateDato.getNombreRecurso());
            recurso.setDisponible(updateDato.getDisponible());
            recurso.setTipoRecursoId(updateDato.getTipoRecursoId());
            recurso.setCategoriaId(updateDato.getCategoriaId());
            recurso.setFecha(updateDato.getFecha());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> RecursoToDTO() {
        return recurso -> new RecursoDTO(recurso.getId(), recurso.getDisponible(), recurso.getFecha()
                , recurso.getNombreRecurso(), recurso.getCategoriaId(), recurso.getTipoRecursoId());
    }
}
