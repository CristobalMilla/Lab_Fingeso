package grupo3.LabFingeso.entity;

import java.util.Date;
import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.entity.arriendoEntity.Comprobante;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private double monto;
    private String metodoPago;
    //ver dependencias circulares (?)
    @OneToOne
    @JoinColumn(name = "arriendo_id")
    @JsonBackReference
    private arriendoEntity arriendo;

    @OneToOne(mappedBy = "pagoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Comprobante comprobante;
}
