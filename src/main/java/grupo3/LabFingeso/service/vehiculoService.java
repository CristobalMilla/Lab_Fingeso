package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehiculoService {
    @Autowired
    private vehiculoRepository vehiculoRepo;

    public vehiculoService(vehiculoRepository vehiculoRepo) {
        this.vehiculoRepo = vehiculoRepo;
    }

    public vehiculoEntity cambiarDisponibilidad(long idVehiculo, String estado){
        vehiculoEntity vehiculo = vehiculoRepo.findByIdIfExist(idVehiculo);
        if(vehiculo != null){
            vehiculo.setEstado(estado);
            if(estado.equalsIgnoreCase("disponible")
            || estado.equalsIgnoreCase("ocupado")
            || estado.equalsIgnoreCase("mantenimiento")) {
                return vehiculoRepo.save(vehiculo);
            }
        }
        return null;
    }

    public vehiculoEntity createVehiculo(vehiculoEntity nuevoVehiculo){
        vehiculoEntity existenteVehiculo = vehiculoRepo.findById(nuevoVehiculo.getidVehiculo()).orElse(null);
        if(existenteVehiculo != null){
            return null;
        }
        else{
            return vehiculoRepo.save(nuevoVehiculo);
        }
    }

    public vehiculoEntity getVehiculoById(long idVehiculo){
        return vehiculoRepo.findByIdIfExist(idVehiculo);
    }

    public vehiculoEntity updateVehiculo(vehiculoEntity vehiculoModificado){
        return vehiculoRepo.save(vehiculoModificado);
    }

    public List<vehiculoEntity> getAllVehiculos(){
        return vehiculoRepo.findAllThatExists();
    }

    public boolean eliminateVehiculoById(long idVehiculo){
        if(vehiculoRepo.findByIdIfExist(idVehiculo) != null){
            try {
                vehiculoRepo.deleteById(idVehiculo);
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
