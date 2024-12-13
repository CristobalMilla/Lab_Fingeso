package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "usuario")
public class usuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private int rut;
    private String nombre;
    private int edad;
    private String correo;
    private String carnet;
    private String licenciaConducir;
    private String contrasena;
    private String perfilActual;
    @ElementCollection
    private ArrayList<String> perfilesDisponibles;


    public usuarioEntity(long idUsuario, int rut, String nombre, int edad, String correo, String carnet, String licenciaConducir, String contrasena) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.carnet = carnet;
        this.licenciaConducir = licenciaConducir;
        this.contrasena = contrasena;
        this.perfilActual = null;
        this.perfilesDisponibles = new ArrayList<>();
        this.perfilesDisponibles.add("usuario");
    }

    public usuarioEntity(int rut, String nombre, int edad, String correo, String carnet, String licenciaConducir, String contrasena) {

    }

    public usuarioEntity() {

    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
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
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfilActual() {
        return perfilActual;
    }

    public void setPerfilActual(String perfilActual) {
        this.perfilActual = perfilActual;
    }

    public ArrayList<String> getPerfilesDisponibles() {
        return perfilesDisponibles;
    }

    public void setPerfilesDisponibles(ArrayList<String> perfilesDisponibles) {
        this.perfilesDisponibles = perfilesDisponibles;
    }
}

