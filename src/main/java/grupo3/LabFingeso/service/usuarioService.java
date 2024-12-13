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

    public int login(String correo, String contrasena) {
        usuarioEntity usuarioActual;
        try {
            usuarioActual = usuarioRepo.findByCorreo(correo);
        } catch (Exception e) {
            System.out.println("Usuario no encontrado con el correo");
            return 0;
        }
        if (usuarioActual.getContrasena().equals(contrasena)) {
            if (usuarioActual.getPerfilActual() == null || usuarioActual.getPerfilActual().isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }else{
            System.out.println("Contraseña incorrecta");
            return 0;
        }
    }


    public void elegirPerfil(String correo, String cambioPerfil) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);

        try{
            if(cambioPerfil.equals("desarrollador") || cambioPerfil.equals("administrador") || cambioPerfil.equals("empleado") || cambioPerfil.equals("cliente") || cambioPerfil.equals("usuario")){
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
            System.out.println("Perfil elegirPerfil no encontrado en el sistema");
        }
    }

    public void cambiarPerfil(String correo, String cambioPerfil) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);

        try{
            if(cambioPerfil.equals("cliente") || cambioPerfil.equals("administrador") || cambioPerfil.equals("empleado")|| cambioPerfil.equals("desarrollador") || cambioPerfil.equals("usuario"))
            {
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
            System.out.println("perfil cambiarPerfil no encontrado en el sistema");
        }
    }

    public void agregarPerfilAUsuarioExistente(String correo, String agregarPerfil, String correoHabilitador) {
        usuarioEntity usuario = usuarioRepo.findByCorreo(correo);
        usuarioEntity usuarioActual = usuarioRepo.findByCorreo(correoHabilitador);

        try{
            if(agregarPerfil.equals("cliente") || agregarPerfil.equals("administrador") || agregarPerfil.equals("empleado")|| agregarPerfil.equals("desarrollador")){
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
                } catch (Exception e) {
                    System.out.println("No tiene el perfil habilitado para realizar esta accion");
                }
            }
        } catch (Exception e){
            System.out.println("perfil no encontrado en el sistema");
        }
    }



    public usuarioEntity getUsuarioById(long idUsuario) {
        return usuarioRepo.findById(idUsuario).orElse(null);
    }

    public usuarioEntity getUsuarioByCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo);
    }

    public List<usuarioEntity> getAllUsuarios() {
        return usuarioRepo.findAll();
    }


    public usuarioEntity updateUsuario(usuarioEntity usuario) {
        return usuarioRepo.save(usuario);
    }


    public void deleteUsuarioById(long idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }
}


