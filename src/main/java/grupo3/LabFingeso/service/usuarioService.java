package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.tipoUsuarioEntity;
import grupo3.LabFingeso.entity.usuarioEntity;
import grupo3.LabFingeso.repository.tipoUsuarioRepository;
import grupo3.LabFingeso.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioService {

    private final usuarioRepository usuarioRepo;
    private tipoUsuarioRepository tipoUsuarioRepo;
    @Autowired
    public usuarioService(usuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public usuarioEntity register(int rut, String nombre, int edad, String correo, String carnet, String licenciaConducir, String contrasena){
        usuarioEntity usuario;
        usuario = new usuarioEntity(rut, nombre, edad, correo, carnet, licenciaConducir, contrasena);
        usuarioEntity existente = usuarioRepo.findByCorreo(usuario.getCorreo());
        if (existente != null){
            return null;
        }
        return usuarioRepo.save(usuario);
    }

    public int login(String correo, String contrasena) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        try {
            if (usuario != null) {
                try{
                    if (usuario.getContrasena().equals(contrasena)) {
                        if (usuario.getPerfilActual() == null || usuario.getPerfilActual().isEmpty()) {
                            return 1; // Logueo exitoso
                        }
                    }
                } catch(Exception e) {
                    System.out.println("Contraseña incorrecta");
                    return 0; // Contraseña incorrecta
                }
            }
        } catch (Exception e) {
                System.out.println("Usuario no encontrado con el correo");
                return 0; // Usuario no encontrado
        }
        return 0;
    }

    public void elegirPerfil(String correo, String cambioPerfil) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        tipoUsuarioEntity existente = tipoUsuarioRepo.findByPerfil(cambioPerfil);

        try{
            if(existente != null){
                try {
                    System.out.println("Los perfiles disponibles del usuario son: ");
                    for(String perfil : usuario.getPerfilesDisponibles()) {
                        System.out.println("Perfil" + perfil);
                    }
                    if (usuario.getPerfilesDisponibles().contains(cambioPerfil)) {
                        usuario.setPerfilActual(cambioPerfil);
                        usuarioRepo.save(usuario);
                    }
                } catch (Exception e) {
                    System.out.println("Perfil elegirPerfil no encontrado dentro de los perfiles disponibles del usuario");
                }
            }

        } catch (Exception e) {
            System.out.println("Perfil elegirPerfil no existente");
        }
    }

    public void cambiarPerfil(String correo, String cambioPerfil) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        tipoUsuarioEntity existente = tipoUsuarioRepo.findByPerfil(cambioPerfil);

        try{
            if(existente != null){
                try {
                    System.out.println("Los perfiles disponibles del usuario son: ");
                    for(String perfil : usuario.getPerfilesDisponibles()) {
                        System.out.println("Perfil" + perfil);
                    }
                    if (usuario.getPerfilesDisponibles().contains(cambioPerfil)) {
                        usuario.setPerfilActual(cambioPerfil);
                        usuarioRepo.save(usuario);
                    }
                } catch (Exception e) {
                    System.out.println("Perfil cambiarPerfil no encontrado dentro de los perfiles disponibles del usuario");
                }
            }

        } catch (Exception e) {
            System.out.println("Perfil cambiarPerfil no existente");
        }
    }

    public void habilitarPerfil(String correo, String agregarPerfil, String perfilHabilitador) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        tipoUsuarioEntity existente = tipoUsuarioRepo.findByPerfil(agregarPerfil);
        try {
            if (existente != null) {
                try {
                    if (perfilHabilitador == "administrador" || perfilHabilitador == "desarrollador") {
                        try {
                            if (!usuario.getPerfilesDisponibles().contains(agregarPerfil)) {
                                usuario.getPerfilesDisponibles().add(agregarPerfil);
                                usuarioRepo.save(usuario);
                            }
                        } catch (Exception e) {
                            System.out.println("El perfil habilitarPerfil ya está habilitado para el usuario");
                        }
                    }
                } catch (Exception e){
                    System.out.println("No tiene el perfil habilitado para realizar esta accion");
                }
            }
        } catch (Exception e){
            System.out.println("Perfil habilitarPerfil no encontrado");
        }
    }

    public usuarioEntity getUsuarioById(long idUsuario) {
        return usuarioRepo.findById(idUsuario).orElse(null);
    }

    public usuarioEntity getUsuarioByCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo);
    }

    public List<usuarioEntity> getAllUsuarios(long idUsuario) {
        return usuarioRepo.findAll();
    }


    public usuarioEntity updateUsuario(usuarioEntity usuario) {
        return usuarioRepo.save(usuario);
    }


    public void deleteUsuarioById(long idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }

}

