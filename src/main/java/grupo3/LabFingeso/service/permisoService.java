package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.permisoEntity;
import grupo3.LabFingeso.repository.permisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class permisoService {

    private final permisoRepository permisoRepo;

    @Autowired
    public permisoService(permisoRepository permisoRepo) {
        this.permisoRepo = permisoRepo;
    }

    public permisoEntity crearPermiso(permisoEntity permiso) {
        return permisoRepo.save(permiso);

    }

    public permisoEntity getPermisoById(long idPermiso) {
        return permisoRepo.findById(idPermiso).orElse(null);
    }

    public permisoEntity updatePermiso(permisoEntity permiso) {
        return permisoRepo.save(permiso);
    }

    public List<permisoEntity> getAllPermisos() {
        return permisoRepo.findAll();
    }

    public void deletePermiso(long idPermiso) {
        permisoRepo.deleteById(idPermiso);
    }



}