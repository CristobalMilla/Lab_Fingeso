package grupo3.LabFingeso.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tipoUsuario")
public class tipoUsuarioEntity {
    /*public enum tipoPermiso{
        habilitarPerfil,
        modificarFlota,
        poderArrendar,
        verRegistro,
        verCatalogo,
        buscarVehiculo,
        modificarVehiculo
    }*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoUsuario;
    private String nombre;
    private String descripcion;
    //private List<String> tipoPermisos;

    //@ManyToMany
    //@JoinTable(name = "tipoUsuario_Usuario",
            //joinColumns = @JoinColumn(name = "tipo_usuario_id"),
            //inverseJoinColumns = @JoinColumn(name = "usuario_id"))
            //private List<usuarioEntity> usuarios;

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

}
