package grupo3.LabFingeso.repository;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.entity.usuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface arriendoRepository extends JpaRepository<arriendoEntity, Long> {
    List<arriendoEntity> findByCliente(usuarioEntity cliente);
}
