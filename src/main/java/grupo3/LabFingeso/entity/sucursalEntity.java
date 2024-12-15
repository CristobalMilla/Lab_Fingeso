package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sucursal")
public class sucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idsucursal;
    private String nombre;
    private String direccion;

    // Constructor
    public sucursalEntity(String nombre, long idsucursal, String direccion) {
        this.nombre = nombre;
        this.idsucursal = idsucursal;
        this.direccion = direccion;
    }

    public sucursalEntity(){

    }

    // Getters

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdSucursal() {
        return idsucursal;
    }

    // Setters

    public void setIdSucursal(long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
