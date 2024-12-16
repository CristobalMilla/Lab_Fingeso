package grupo3.LabFingeso.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

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
                          vehiculoEntity vehiculo, sucursalEntity sucursalrecogida, sucursalEntity sucursaldevolucion, comprobanteEntity comprobante) {
        this.idarriendo = idarriendo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.costototal = costototal;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.sucursalrecogida = sucursalrecogida;
        this.sucursaldevolucion = sucursaldevolucion;
        this.comprobante = comprobante;
    }

    public arriendoEntity() {

    }

    // GETTERS

    public long getIdarriendo() {
        return idarriendo;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public double getCostototal() {
        return costototal;
    }

    public String getEstado() {
        return estado;
    }

    public usuarioEntity getCliente() {
        return cliente;
    }

    public vehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public sucursalEntity getSucursalrecogida() {
        return sucursalrecogida;
    }

    public sucursalEntity getSucursaldevolucion() {
        return sucursaldevolucion;
    }

    public comprobanteEntity getComprobante() {
        return comprobante;
    }

    // SETTERS


    public void setIdarriendo(long idarriendo) {
        this.idarriendo = idarriendo;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public void setCostototal(double costototal) {
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

    public void setSucursalrecogida(sucursalEntity sucursalrecogida) {
        this.sucursalrecogida = sucursalrecogida;
    }

    public void setSucursaldevolucion(sucursalEntity sucursaldevolucion) {
        this.sucursaldevolucion = sucursaldevolucion;
    }

    public void setComprobante(comprobanteEntity comprobante) {
        this.comprobante = comprobante;
    }
}
