package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.usuarioTipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface permisoRepository extends JpaRepository<usuarioTipoUsuario, Long> {

}
