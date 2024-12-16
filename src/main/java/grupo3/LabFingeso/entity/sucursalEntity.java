package grupo3.LabFingeso.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursal")
public class sucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsucursal;
    private String nombre;
    private String direccion;

    // Constructor
    public sucursalEntity(long idsucursal, String nombre, String direccion) {
        this.idsucursal = idsucursal;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public sucursalEntity(){

    }

    // Getters

    public long getIdsucursal() {
        return idsucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }


    // Setters


    public void setIdsucursal(long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
