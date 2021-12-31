package co.com.sofka.Biblioteca.usecase.categoria;

import co.com.sofka.Biblioteca.mapper.CategoriaMapper;
import co.com.sofka.Biblioteca.repositorios.RepositorioCategoria;
import co.com.sofka.Biblioteca.usecase.categoria.interfaz.EliminarCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EliminarCategoriaUseCase implements EliminarCategoria {

    private final RepositorioCategoria repositorioCategoria;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public EliminarCategoriaUseCase(RepositorioCategoria repositorioCategoria, CategoriaMapper categoriaMapper) {
        this.repositorioCategoria = repositorioCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    public Mono<Void> deleteByIdCategoria(String id) {
        return repositorioCategoria.deleteById(id);
    }

}
