package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.tipoUsuarioEntity;
import grupo3.LabFingeso.repository.tipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tipoUsuarioService {

    private final tipoUsuarioRepository tipoUsuarioRepo;

    @Autowired
    public tipoUsuarioService(tipoUsuarioRepository tipoUsuarioRepo) {
        this.tipoUsuarioRepo = tipoUsuarioRepo;
    }

    public tipoUsuarioEntity createTipoUsuario(tipoUsuarioEntity tipoUsuario) {
        return tipoUsuarioRepo.save(tipoUsuario);
    }
    public tipoUsuarioEntity getTipoUsuarioById(long idTipoUsuario) {
        return tipoUsuarioRepo.findById(idTipoUsuario).orElse(null);
    }

    public List<tipoUsuarioEntity> getAlltipoUsuario() {
        return tipoUsuarioRepo.findAll();
    }

    public tipoUsuarioEntity updateAnimal(tipoUsuarioEntity animal) {
        return tipoUsuarioRepo.save(animal);
    }


    public void deletetipoUsuario(long idTipoUsuario) {
        tipoUsuarioRepo.deleteById(idTipoUsuario);
    }
}
