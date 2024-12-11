package grupo3.LabFingeso.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tipoUsuario")
public class tipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoUsuario;
    private String nombre;
    private String descripcion;

    @ManyToMany(targetEntity = permisoEntity.class)
    private Set permisoSet;

    public tipoUsuarioEntity(long idTipoUsuario, String nombre, String descripcion) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public tipoUsuarioEntity() {

    }


    public long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set getPermisoSet() {
        return permisoSet;
    }

    public void setPermisoSet(Set permisoSet) {
        this.permisoSet = permisoSet;
    }
}
