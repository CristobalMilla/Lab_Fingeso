package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.vehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vehiculoRepository extends JpaRepository<vehiculoEntity, Long> {
}
