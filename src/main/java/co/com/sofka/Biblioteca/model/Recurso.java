package co.com.sofka.Biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recurso {

    @Id
    private String id;
    private boolean disponible;
    private String fecha;
    private String nombreRecurso;
    private String tipoRecursoId;
    private String categoriaId;

    public Recurso() {
    }

    public Recurso(String id, boolean disponible, String fecha, String nombreRecurso, String tipoRecursoId, String categoriaId) {
        this.id = id;
        this.disponible = disponible;
        this.fecha = fecha;
        this.nombreRecurso = nombreRecurso;
        this.tipoRecursoId = tipoRecursoId;
        this.categoriaId = categoriaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(String tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
}
