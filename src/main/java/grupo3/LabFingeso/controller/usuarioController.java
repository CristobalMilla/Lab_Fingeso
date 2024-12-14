package grupo3.LabFingeso.controller;


import grupo3.LabFingeso.entity.usuarioEntity;
import grupo3.LabFingeso.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/login/")
    public int login(@RequestBody usuarioEntity x){
        return usuarioService.login(x.getCorreo(), x.getContrasena());
    }

    @PostMapping("/elegirPerfil/")
    public void elegirPerfil(@RequestBody usuarioEntity x, @RequestParam String perfilNuevo){
        usuarioService.elegirPerfil(x.getCorreo(), perfilNuevo);
    }

    @PostMapping("/cambiarPerfil/")
    public void cambiarPerfil(@RequestBody usuarioEntity nuevo, @RequestParam String perfilNuevo){
        usuarioService.cambiarPerfil(nuevo.getCorreo(), perfilNuevo);
    }

    @PostMapping("/obtenerUsuario/{correoUsuario}/")
    public usuarioEntity getUsuarioByName(@PathVariable String correoUsuario){
        return usuarioService.getUsuarioByCorreo(correoUsuario);
    }
    @PostMapping("/agregarPerfilAUsuarioExistente/")
    public void agregarPerfilAUsuarioExistente(@RequestBody usuarioEntity x, @RequestParam String perfilNuevo, @RequestBody usuarioEntity usuarioHabilitador){
        usuarioService.agregarPerfilAUsuarioExistente(x.getCorreo(), perfilNuevo, usuarioHabilitador.getPerfilActual());
    }

    @GetMapping("/obtenerUsuario/{idUsuario}")
    public usuarioEntity getUsuarioById(@PathVariable long idUsuario){
        return usuarioService.getUsuarioById(idUsuario);
    }

    @GetMapping("/obtenerTodosUsuarios/")
    public List<usuarioEntity> getAllUsuario(){
        return usuarioService.getAllUsuarios();
    }

    @PutMapping("/actualizarUsuarioBy")
    public usuarioEntity updateUsuario(@RequestBody usuarioEntity usuarioModificado){
        return usuarioService.updateUsuario(usuarioModificado);
    }

    @DeleteMapping("/eliminarUsuario;")
    public void deleteUsuarioById(@RequestParam long idUsuario){
        usuarioService.deleteUsuarioById(idUsuario);
    }



}
