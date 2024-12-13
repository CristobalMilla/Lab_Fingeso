package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.repository.arriendoRepository;
import grupo3.LabFingeso.repository.usuarioRepository;
import grupo3.LabFingeso.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class arriendoService {
    @Autowired
    private arriendoRepository arriendoRepo;

    @Autowired
    private vehiculoRepository vehiculoRepo;

    @Autowired
    private usuarioRepository usuarioRepo;

    public arriendoService(arriendoRepository arriendoRepo, vehiculoRepository vehiculoRepo, usuarioRepository usuarioRepo) {
        this.arriendoRepo = arriendoRepo;
        this.vehiculoRepo = vehiculoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    private boolean esPeriodoValido(Date fechaInicio, Date fechaFin){
        long diferenciaFechas = fechaFin.getTime() - fechaInicio.getTime(); // queda en milisegundos
        long treintaDiasMilisegundos = 2592000000L;
        if(diferenciaFechas > 0 && diferenciaFechas > treintaDiasMilisegundos){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean usuarioTieneArriendoActivo(long idUsuario){
        for(arriendoEntity arriendoUsuario : arriendoRepo.findByCliente(usuarioRepo.findById(idUsuario).orElse(null))){
            if(arriendoUsuario != null){
                if(arriendoUsuario.getEstado().equalsIgnoreCase("en uso")
                || arriendoUsuario.getEstado().equalsIgnoreCase("retirar")
                || arriendoUsuario.getEstado().equalsIgnoreCase("retraso")){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean comprobarFechasOtrosArriendos(arriendoEntity nuevoArriendo){
        nuevoArriendo.getVehiculo().getidVehiculo();
        return false;
    }

    public arriendoEntity arrendar(arriendoEntity nuevoArriendo) {
        try {
            long idVehiculo = nuevoArriendo.getVehiculo().getidVehiculo();
            if(arriendoRepo.findById(nuevoArriendo.getIdArriendo()).orElse(null) != null   // id duplicado
            || vehiculoRepo.findById(idVehiculo).orElse(null) == null                      // no existe el vehiculo en la bd
            || !(vehiculoRepo.findById(idVehiculo).orElse(null).getEstado().equalsIgnoreCase("disponible")) // si no esta disponible
            || usuarioTieneArriendoActivo(nuevoArriendo.getCliente().getIdUsuario())             // se pasa de los 30 dias
            || comprobarFechasOtrosArriendos(nuevoArriendo)                                      // si es que el vehiculo no esta reservado entre las fechas
            || !(esPeriodoValido(nuevoArriendo.getFechaInicio(), nuevoArriendo.getFechaFin()))){ // si el usuario tiene arriendo activo
                return null;
            }
            else {
                nuevoArriendo.setVehiculo(vehiculoRepo.findById(idVehiculo).orElse(null));
                return arriendoRepo.save(nuevoArriendo);
            }
        }
        catch(Exception e){
            return null;
        }
    }

    public List<arriendoEntity> getArriendoByidCliente(long idUsuario){
        try {
            return arriendoRepo.findByCliente(usuarioRepo.findById(idUsuario).orElse(null));
        }
        catch (Exception e) {
            return null;
        }
    }

    public arriendoEntity getArriendoById(long idArriendo){
        return arriendoRepo.findById(idArriendo).orElse(null);
    }

    public List<arriendoEntity> getAllArriendos(){
        return arriendoRepo.findAll();
    }

    public arriendoEntity updateArriendo(arriendoEntity arriendoModificado){
        return arriendoRepo.save(arriendoModificado);
    }

    public boolean eliminateArriendoById(long idArriendo){
        if(arriendoRepo.findById(idArriendo).orElse(null) != null){
            try {
                arriendoRepo.deleteById(idArriendo);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
        else{
            return false;
        }
    }
}
