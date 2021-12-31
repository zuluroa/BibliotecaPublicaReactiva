package co.com.sofka.Biblioteca.mapper;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoriaMapper {
    public Function<CategoriaDTO, Categoria> dtoToCategoria() {
        return updateCategoria -> {
            var categoria = new Categoria();
            categoria.setCategoriaId(updateCategoria.getCategoriaId());
            categoria.setNombreCategoria(updateCategoria.getNombreCategoria());
            return categoria;
        };
    }

    public Function<Categoria, CategoriaDTO> CategoriaToDTO() {
        return entity -> new CategoriaDTO(entity.getCategoriaId(), entity.getNombreCategoria());
    }
}
