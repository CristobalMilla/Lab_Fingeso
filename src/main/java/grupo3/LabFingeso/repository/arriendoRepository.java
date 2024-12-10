package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.arriendoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface arriendoRepository extends JpaRepository<arriendoEntity, Long> {
}
