package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.sucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sucursalRepository extends JpaRepository<sucursalEntity, Long> {
}
