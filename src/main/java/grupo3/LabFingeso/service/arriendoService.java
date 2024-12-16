package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.entity.vehiculoEntity;
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
        System.out.println("A");
        long diferenciaFechas = fechaFin.getTime() - fechaInicio.getTime(); // queda en milisegundos
        long treintaDiasMilisegundos = 2592000000L;
        if(diferenciaFechas > 0 && diferenciaFechas > treintaDiasMilisegundos){
            System.out.println("Fechas invalidas");
            return false;
        }
        else{
            return true;
        }
    }

    private boolean usuarioTieneArriendoActivo(long idUsuario){
        System.out.println("B");
        for(arriendoEntity arriendoUsuario : arriendoRepo.findByidCliente(idUsuario)){
            System.out.println("B1");
            if(arriendoUsuario != null){
                System.out.println("B2");
                if(arriendoUsuario.getEstado().equalsIgnoreCase("en uso")
                || arriendoUsuario.getEstado().equalsIgnoreCase("retirar")
                || arriendoUsuario.getEstado().equalsIgnoreCase("retraso")){
                    System.out.println("Ya tiene arriendo");
                    return true;
                }
            }
        }
        System.out.println("B3");
        return false;
    }

    private boolean comprobarFechasOtrosArriendos(arriendoEntity nuevoArriendo, long idVehiculo){
        System.out.println("C " + nuevoArriendo.getFechainicio().getTime());
        for(arriendoEntity arriendoExistente : arriendoRepo.findByVehiculo(idVehiculo)) {
            System.out.println("d " + arriendoExistente.getFechainicio().getTime());
            if (arriendoExistente.getFechainicio().getTime() > nuevoArriendo.getFechainicio().getTime()
                    || arriendoExistente.getFechainicio().getTime() < nuevoArriendo.getFechafin().getTime()) {
                System.out.println("topa oe");
                return true;
            }
        }
        return false;
    }

    public arriendoEntity arrendar(arriendoEntity nuevoArriendo, long idUsuario, long idVehiculo, long idComprobante) {
        try {
            if(vehiculoRepo.findById(idUsuario).orElse(null) == null){
                return null;// no "existe" el usuario ingresado
            }
            if(vehiculoRepo.findByIdIfExist(idVehiculo) == null){
                return null;// no "existe" el vehiculo en la bd
            }
            if(!(vehiculoRepo.findByIdIfExist(idVehiculo).getEstado().equalsIgnoreCase("disponible"))){
                return null;// si no esta disponible
            }
            if(usuarioTieneArriendoActivo(idUsuario)){
                return null;// se pasa de los 30 dias
            }
            if(comprobarFechasOtrosArriendos(nuevoArriendo, idVehiculo)){
                return null;// si es que el vehiculo no esta reservado entre las fechas
            }
            if(!(esPeriodoValido(nuevoArriendo.getFechainicio(), nuevoArriendo.getFechafin()))){ // si el usuario tiene arriendo activo
                return null;
            }
            else {
                nuevoArriendo.setCliente(usuarioRepo.findById(idUsuario).orElse(null));
                nuevoArriendo.setVehiculo(vehiculoRepo.findByIdIfExist(idVehiculo));
                return arriendoRepo.save(nuevoArriendo);
            }
        }
        catch(Exception e){
            return null;
        }
    }

    public List<arriendoEntity> getArriendoByidCliente(long idUsuario){
        try {
            return arriendoRepo.findByidCliente(idUsuario);
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
