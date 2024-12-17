package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.arriendoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface arriendoRepository extends JpaRepository<arriendoEntity, Long> {
    @Query(value = "SELECT * FROM arriendo WHERE cliente = :idcliente", nativeQuery = true)
    List<arriendoEntity> findByidCliente(long idcliente);

    @Query(value = "SELECT * FROM arriendo WHERE vehiculo = :idvehiculo", nativeQuery = true)
    List<arriendoEntity> findByVehiculo(long idvehiculo);

    boolean deleteById(long idarriendo);
}
