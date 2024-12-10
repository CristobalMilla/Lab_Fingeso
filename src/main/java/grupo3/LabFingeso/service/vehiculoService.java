package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.sucursalEntity;
import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vehiculoService {
    @Autowired
    private vehiculoRepository vehiculoRepo;

    public vehiculoEntity crearVehiculo(long idVehiculo, String marca, String modelo, String matricula, String tipo, int kilometraje, String estado, sucursalEntity sucursal, double precioBase){
        vehiculoEntity nuevoVehiculo = new vehiculoEntity(idVehiculo, marca, modelo, matricula, tipo, kilometraje, estado, sucursal, precioBase);
        vehiculoEntity existenteVehiculo = vehiculoRepo.findById(nuevoVehiculo.getidVehiculo());
        if(existenteVehiculo != null){
            return null;
        }
        else{
            return vehiculoRepo.save(nuevoVehiculo);
        }
    }

    public boolean eliminarVehiculo(long idVehiculo){
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
