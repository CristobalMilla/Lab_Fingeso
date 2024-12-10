package grupo3.LabFingeso.entity;

import java.util.Date;
import grupo3.LabFingeso.entity.arriendoEntity;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class pagoEntity {
    private Date fecha;
    private double monto;
    private String metodoPago;
    //ver dependencias circulares (?)
    private arriendoEntity arriendo;
}
