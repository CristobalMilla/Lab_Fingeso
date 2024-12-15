package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "arriendo")
public class arriendoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idarriendo;
    private Date fechainicio;
    private Date fechafin;
    private double costototal;
    private String estado;
    @OneToOne
    @JoinColumn(name = "cliente")
    private usuarioEntity cliente;
    @OneToOne
    @JoinColumn(name = "vehiculo")
    private vehiculoEntity vehiculo;
    @OneToOne
    @JoinColumn(name = "sucursalrecogida")
    private sucursalEntity sucursalrecogida;
    @OneToOne
    @JoinColumn(name = "sucursaldevolucion")
    private sucursalEntity sucursaldevolucion = null; // De primera no se sabe donde se devuelve(?
    @OneToOne
    @JoinColumn(name = "comprobante")
    private comprobanteEntity comprobante;

    // Constructor
    public arriendoEntity(long idarriendo, Date fechainicio, Date fechafin, double costototal, String estado, usuarioEntity cliente,
                          vehiculoEntity vehiculo, sucursalEntity sucursalrecogida, comprobanteEntity comprobante){
        this.idarriendo = idarriendo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.costototal = costototal;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.sucursalrecogida = sucursalrecogida;
        this.comprobante = comprobante;
    }

    public arriendoEntity(){

    }

    // Getters
    public long getIdArriendo() {
        return idarriendo;
    }

    public Date getFechaInicio() {
        return fechainicio;
    }

    public double getCostoTotal() {
        return costototal;
    }

    public Date getFechaFin() {
        return fechafin;
    }

    public String getEstado() {
        return estado;
    }

    public vehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public usuarioEntity getCliente() {
        return cliente;
    }

    public sucursalEntity getSucursalRecogida() {
        return sucursalrecogida;
    }

    public sucursalEntity getSucursalDevolucion() {
        return sucursaldevolucion;
    }

    public comprobanteEntity getComprobante() {
        return comprobante;
    }

    // Setters

    public void setIdArriendo(long idarriendo) {
        this.idarriendo = idarriendo;
    }

    public void setFechaInicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechaFin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public void setCostoTotal(double costototal) {
        this.costototal = costototal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCliente(usuarioEntity cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(vehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setSucursalRecogida(sucursalEntity sucursalrecogida) {
        this.sucursalrecogida = sucursalrecogida;
    }

    public void setSucursalDevolucion(sucursalEntity sucursaldevolucion) {
        this.sucursaldevolucion = sucursaldevolucion;
    }

    public void setComprobante(comprobanteEntity comprobante) {
        this.comprobante = comprobante;
    }
}
