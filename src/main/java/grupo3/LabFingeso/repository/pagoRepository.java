package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.pagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagoRepository extends JpaRepository<pagoEntity, Long> {
}
