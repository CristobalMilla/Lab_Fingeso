package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.tipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoUsuarioRepository extends JpaRepository<tipoUsuarioEntity, Long> {
    tipoUsuarioEntity findByPerfil(String perfil);
}
