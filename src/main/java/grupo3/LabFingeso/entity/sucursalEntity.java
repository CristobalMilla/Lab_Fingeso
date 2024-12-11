package grupo3.LabFingeso.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sucursal")
@NoArgsConstructor
public class sucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idSucursal;
    private String nombre;
    private String direccion;
    @ElementCollection
    private List<vehiculoEntity> vehiculos;

    // Constructor
    public sucursalEntity(String nombre, long idSucursal, String direccion, List<vehiculoEntity> vehiculos) {
        this.nombre = nombre;
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.vehiculos = vehiculos;
    }

    // Getters
    public List<vehiculoEntity> getVehiculos() {
        return vehiculos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    // Setters

    public void setIdSucursal(long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setVehiculos(List<vehiculoEntity> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
