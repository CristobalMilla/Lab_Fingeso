package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.usuarioEntity;
import grupo3.LabFingeso.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioService {
    @Autowired
    private usuarioRepository usuarioRepo;
    public usuarioEntity register(int rut, String nombre, int edad, String correo, String carnet, String licenciaConducir, String contrasena){
        usuarioEntity usuario;
        usuario = new usuarioEntity(rut, nombre, edad, correo, carnet, licenciaConducir, contrasena);
        usuarioEntity existente = usuarioRepo.findByCorreo(usuario.getCorreo());
        if (existente != null){
            return null;
        }
        return usuarioRepo.save(usuario);
    }
}
