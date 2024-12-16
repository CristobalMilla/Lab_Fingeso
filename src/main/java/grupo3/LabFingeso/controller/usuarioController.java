package grupo3.LabFingeso.controller;


import grupo3.LabFingeso.entity.usuarioEntity;
import grupo3.LabFingeso.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/login/")
    public int login(@RequestBody usuarioEntity x){
        return usuarioService.login(x.getCorreo(), x.getContrasena());
    }

    @PutMapping("/elegirPerfil/")
    public void elegirPerfil(@RequestBody usuarioEntity x){
        usuarioService.elegirPerfil(x.getCorreo(), x.getPerfilActual());
    }

    @PostMapping("/cambiarPerfil/")
    public void cambiarPerfil(@RequestBody usuarioEntity nuevo){
        usuarioService.cambiarPerfil(nuevo.getCorreo(), nuevo.getPerfilActual());
    }

    @PostMapping("/obtenerUsuario/{correoUsuario}/")
    public usuarioEntity getUsuarioByName(@PathVariable String correoUsuario){
        return usuarioService.getUsuarioByCorreo(correoUsuario);
    }

    @PutMapping("/agregarPerfil/")
    public void agregarPerfilAUsuarioExistente(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String perfilNuevo = datos.get("perfilActual"); // Según tu JSON actual
        String correoHabilitador = datos.get("correoHabilitador");

        usuarioService.agregarPerfilAUsuarioExistente(correo, perfilNuevo, correoHabilitador);
    }

    /*@GetMapping("/obtenerPerfilesDisponibles/{id}")
    public List<String> getPerfilesDisponiblesById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id).getPerfilesDisponibles();
    }*/

    @GetMapping("/obtenerUsuarioById/{id}")
    public usuarioEntity getPerfilesDisponiblesById(@PathVariable long id) {
        return usuarioService.getUsuarioById(id);
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
        return usuarioService.updateUsuario(usuarioModificado.getCorreo(), usuarioModificado.getPerfilActual());
    }

    @PutMapping("/actualizarUsuario2")
    public void updateUsuario2(@RequestBody usuarioEntity usuarioModificado) {
        usuarioService.updateUsuario2(usuarioModificado.getCorreo(), usuarioModificado.getPerfilActual());
    }

    @DeleteMapping("/eliminarUsuario;")
    public void deleteUsuarioById(@RequestParam long idUsuario){
        usuarioService.deleteUsuarioById(idUsuario);
    }



}
