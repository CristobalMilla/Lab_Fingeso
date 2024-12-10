package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class vehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idUsuario;
    private String marca;
    private String modelo;
    private String tipo;
    private String matricula;
    private int kilometraje;
    private String estado;
    private Sucursal sucursal;
    private double precioBase;

    // Constructor
    public vehiculoEntity(long idUsuario, String marca, String modelo, String matricula, String tipo, int kilometraje, String estado, Sucursal sucursal, double precioBase) {
        this.idUsuario = idUsuario;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.sucursal = sucursal;
        this.precioBase = precioBase;
    }

    // Getters
    public long getIdUsuario() {
        return idUsuario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
