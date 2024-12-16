package grupo3.LabFingeso.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tipoUsuario")
public class tipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtipousuario;
    private String nombre;
    private long idusuario;

    //@ManyToMany
    //@JoinTable(name = "tipoUsuario_Usuario",
            //joinColumns = @JoinColumn(name = "tipo_usuario_id"),
            //inverseJoinColumns = @JoinColumn(name = "usuario_id"))
            //private List<usuarioEntity> usuarios;

    public tipoUsuarioEntity() {

    }

    public tipoUsuarioEntity(long idtipousuario, String nombre, long idusuario) {
        this.idtipousuario = idtipousuario;
        this.nombre = nombre;
        this.idusuario = idusuario;
    }

    public long getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(long idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }
}
