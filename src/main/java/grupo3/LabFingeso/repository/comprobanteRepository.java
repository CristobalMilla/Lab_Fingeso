package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.comprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface comprobanteRepository extends JpaRepository<comprobanteEntity, Long> {
}

