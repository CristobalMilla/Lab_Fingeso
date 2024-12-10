package grupo3.LabFingeso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class tipoUsuarioPermiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idTipoUsuario;
    private long idPermiso;


    public tipoUsuarioPermiso(long id, long idTipoUsuario, long idPermiso) {
        this.id = id;
        this.idTipoUsuario = idTipoUsuario;
        this.idPermiso = idPermiso;
    }

    public tipoUsuarioPermiso() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(long idPermiso) {
        this.idPermiso = idPermiso;
    }
}
