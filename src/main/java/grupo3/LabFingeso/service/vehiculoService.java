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

    public vehiculoEntity createVehiculo(vehiculoEntity nuevoVehiculo){
        vehiculoEntity existenteVehiculo = vehiculoRepo.findById(nuevoVehiculo.getidVehiculo());
        if(existenteVehiculo != null){
            return null;
        }
        else{
            return vehiculoRepo.save(nuevoVehiculo);
        }
    }

    public vehiculoEntity getVehiculoById(long idVehiculo){
        return vehiculoRepo.findById(idVehiculo);
    }

    public vehiculoEntity updateVehiculo(vehiculoEntity vehiculoModificado){
        return vehiculoRepo.save(vehiculoModificado);
    }

    public List<vehiculoEntity> getAllVehiculos(){
        return vehiculoRepo.findAll();
    }

    public boolean eliminateVehiculo(long idVehiculo){
        if(vehiculoRepo.findById(idVehiculo) != null){
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
