package grupo3.LabFingeso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private int rut;
    private String nombre;
    private int edad;
    private String correo;
    private String licenciaConducir;
    private String contrasena;


    public long getIdUsuario() {
        return idUsuario;
    }

    public int getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public usuarioEntity(long idUsuario, int rut, String nombre, int edad, String correo, String licenciaConducir, String contrasena) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.licenciaConducir = licenciaConducir;
        this.contrasena = contrasena;
    }

    public usuarioEntity() {

    }
}

