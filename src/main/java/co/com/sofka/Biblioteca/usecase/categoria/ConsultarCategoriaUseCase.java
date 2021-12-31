package co.com.sofka.Biblioteca.usecase.categoria;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.mapper.CategoriaMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioCategoria;
import co.com.sofka.Biblioteca.usecase.categoria.interfaz.ConsultarCategoria;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class ConsultarCategoriaUseCase implements ConsultarCategoria {

    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    public ConsultarCategoriaUseCase(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Flux<CategoriaDTO> get() {
        return repositorioCategoria.findAll().map(categoriaMapper.CategoriaToDTO());
    }
}
