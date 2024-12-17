package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class vehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idvehiculo;
    private String marca;
    private String modelo;
    private String tipo;
    private String matricula;
    private int kilometraje;
    private String estado;
    private double preciobase;
    private char categoria;
    private char transmision;
    private char combustible;
    private String fotovehiculo;
    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private sucursalEntity sucursal;

    // Constructor
    public vehiculoEntity(long idvehiculo, String marca, String modelo, String matricula, String tipo, int kilometraje, String estado,
                          double preciobase, char categoria, char transmision, char combustible, String fotovehiculo, sucursalEntity sucursal) {
        this.idvehiculo = idvehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.preciobase = preciobase;
        this.categoria = categoria;
        this.transmision = transmision;
        this.combustible = combustible;
        this.fotovehiculo = fotovehiculo;
        this.sucursal = sucursal;
    }

    public vehiculoEntity() {
    }

    // Getters


    public long getIdvehiculo() {
        return idvehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getEstado() {
        return estado;
    }

    public double getPreciobase() {
        return preciobase;
    }

    public char getCategoria() {
        return categoria;
    }

    public char getTransmision() {
        return transmision;
    }

    public char getCombustible() {
        return combustible;
    }

    public String getFotovehiculo() {
        return fotovehiculo;
    }

    public sucursalEntity getSucursal() {
        return sucursal;
    }

    // Setters


    public void setIdvehiculo(long idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public void setPreciobase(double preciobase) {
        this.preciobase = preciobase;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public void setTransmision(char transmision) {
        this.transmision = transmision;
    }

    public void setCombustible(char combustible) {
        this.combustible = combustible;
    }

    public void setFotovehiculo(String fotovehiculo) {
        this.fotovehiculo = fotovehiculo;
    }

    public void setSucursal(sucursalEntity sucursal) {
        this.sucursal = sucursal;
    }
}
