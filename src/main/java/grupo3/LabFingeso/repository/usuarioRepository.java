package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.usuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<usuarioEntity, Long> {
    usuarioEntity findByCorreo(String email);

}
