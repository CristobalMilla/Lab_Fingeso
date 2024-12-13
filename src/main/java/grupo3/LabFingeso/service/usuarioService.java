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

    public usuarioEntity registro(int rut, String nombre, int edad,
                                  String correo, String carnet, String licenciaConducir,
                                  String contrasena) {
        usuarioEntity usuario;
        usuario = new usuarioEntity(rut, nombre, edad, correo, carnet, licenciaConducir, contrasena);
        usuarioEntity existente = usuarioRepo.findByCorreo(usuario.getCorreo());
        if (existente != null){
            return null;
        }
        return usuarioRepo.save(usuario);
    }

    public usuarioEntity login(String correo, String contrasena) {
        usuarioEntity usuarioActual;
        try {
             usuarioActual = usuarioRepo.findByCorreo(correo);

        } catch (Exception e) {
            System.out.println("Usuario no encontrado con el correo");
            return null;
        }
        if (usuarioActual.getContrasena().equals(contrasena)) {
            if (usuarioActual.getPerfilActual() == null || usuarioActual.getPerfilActual().isEmpty()) {
                return usuarioActual;
            } else {
                return null;
            }
        }else{
            System.out.println("Contraseña incorrecta");
            return null;
        }
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

    public void agregarPerfilAUsuarioExistente(String correo, String agregarPerfil) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        tipoUsuarioEntity existente = tipoUsuarioRepo.findByPerfil(agregarPerfil);
            if (existente != null) {
                try {
                    if (usuarioActual.getPerfilActual().equals("administrador") || usuarioActual.getPerfilActual().equals("desarrollador")) {
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

