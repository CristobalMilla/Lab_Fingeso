package grupo3.LabFingeso.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "arriendo")
@NoArgsConstructor
public class arriendoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idArriendo;
    private Date fechaInicio;
    private Date fechaFin;
    private double costoTotal;
    /* en uso
     * retraso
     * terminado
     * retirar   */
    private String estado;
    @OneToOne
    private usuarioEntity cliente;
    @OneToOne
    private vehiculoEntity vehiculo;
    @OneToOne
    private sucursalEntity sucursalRecogida;
    @OneToOne
    private sucursalEntity sucursalDevolucion = null; // De primera no se sabe donde se devuelve(?
    @OneToOne
    private pagoEntity Pago;
    @OneToOne
    private comprobanteEntity comprobante;

    // Constructor
    public arriendoEntity(long idArriendo, Date fechaInicio, Date fechaFin, double costoTotal, String estado, usuarioEntity cliente,
                          vehiculoEntity vehiculo, sucursalEntity sucursalRecogida, pagoEntity pago, comprobanteEntity comprobante){
        this.idArriendo = idArriendo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.sucursalRecogida = sucursalRecogida;
        this.Pago = pago;
        this.comprobante = comprobante;
    }

    // Getters
    public long getIdArriendo() {
        return idArriendo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Date getFechaFin() {
        return fechaFin;
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
        return sucursalRecogida;
    }

    public sucursalEntity getSucursalDevolucion() {
        return sucursalDevolucion;
    }

    public pagoEntity getPago() {
        return Pago;
    }

    public comprobanteEntity getComprobante() {
        return comprobante;
    }

    // Setters

    public void setIdArriendo(long idArriendo) {
        this.idArriendo = idArriendo;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
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

    public void setSucursalRecogida(sucursalEntity sucursalRecogida) {
        this.sucursalRecogida = sucursalRecogida;
    }

    public void setSucursalDevolucion(sucursalEntity sucursalDevolucion) {
        this.sucursalDevolucion = sucursalDevolucion;
    }

    public void setPago(pagoEntity pago) {
        this.Pago = pago;
    }

    public void setComprobante(comprobanteEntity comprobante) {
        this.comprobante = comprobante;
    }
}
