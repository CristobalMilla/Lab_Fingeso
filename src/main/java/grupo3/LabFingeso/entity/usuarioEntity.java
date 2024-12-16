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
    @Column(nullable = false, unique = true)
    private String correo;
    private String carnet;
    private String licenciaconducir;
    private String contrasena;
    private String perfilactual;

    @ElementCollection
    @CollectionTable(name = "perfilesdisponibles", joinColumns = @JoinColumn(name = "idusuario"))
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

    public long getIdusuario() {
        return idusuario;
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

    public String getCarnet() {
        return carnet;
    }

    public String getLicenciaconducir() {
        return licenciaconducir;
    }

    public String getPerfilactual() {
        return perfilactual;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<String> getPerfilesdisponibles() {
        return perfilesdisponibles;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
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

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setLicenciaconducir(String licenciaconducir) {
        this.licenciaconducir = licenciaconducir;
    }

    public void setPerfilactual(String perfilactual) {
        this.perfilactual = perfilactual;
    }

    public void setPerfilesdisponibles(List<String> perfilesdisponibles) {
        this.perfilesdisponibles = perfilesdisponibles;
    }
}

