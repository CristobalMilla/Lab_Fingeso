package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.usuarioEntity;
import grupo3.LabFingeso.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class usuarioController {
    @Autowired
    private usuarioService usuarioService;

    @PostMapping("/register")
    public usuarioEntity registro(@RequestBody usuarioEntity nuevoUsuario) {
        return usuarioService.registro(nuevoUsuario.getRut(), nuevoUsuario.getNombre(),
                nuevoUsuario.getEdad(), nuevoUsuario.getCorreo(), nuevoUsuario.getCarnet(),
                nuevoUsuario.getLicenciaConducir(), nuevoUsuario.getContrasena()
        );
    }

}
