package grupo3.LabFingeso.entity;

import java.util.Date;
//import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.entity.pagoEntity;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comprobantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class comprobanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private double monto;
    private String metodoPago;
    private String recibo;
    
    //ver dependencias circulares (?)
    /*
    @OneToOne
    @JoinColumn(name = "arriendo_id")
    @JsonBackReference
    private arriendoEntity arriendo;
    */

    @OneToOne
    @JoinColumn(name = "pago_id")
    //@JsonBackReference
    private pagoEntity pago;
}
