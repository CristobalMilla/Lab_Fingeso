package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class usuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idusuario;
    private int rut;
    private String nombre;
    private int edad;
    private String correo;
    private String carnet;
    private String licenciaconducir;
    private String contrasena;
    private String perfilactual;

    @ElementCollection
    @CollectionTable(name = "usuario_perfiles", joinColumns = @JoinColumn(name = "idUsuario"))
    @Column(name = "perfil")
    private List<String> perfilesdisponibles;


    public usuarioEntity(int rut, String nombre, int edad, String correo, String carnet, String licenciaconducir, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.carnet = carnet;
        this.licenciaconducir = licenciaconducir;
        this.contrasena = contrasena;
        this.perfilactual = null;
        this.perfilesdisponibles = new ArrayList<>();
        this.perfilesdisponibles.add("usuario");
    }

    public usuarioEntity() {
    }

    public long getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getLicenciaConducir() {
        return licenciaconducir;
    }

    public void setLicenciaConducir(String licenciaconducir) {
        this.licenciaconducir = licenciaconducir;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfilActual() {
        return perfilactual;
    }

    public void setPerfilActual(String perfilactual) {
        this.perfilactual = perfilactual;
    }


    public List<String> getPerfilesDisponibles() {
        return perfilesdisponibles;
    }

    public void setPerfilesDisponibles(List<String> perfilesdisponibles) {
        this.perfilesdisponibles = perfilesdisponibles;
    }
}

