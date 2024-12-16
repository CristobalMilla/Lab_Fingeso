package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.repository.sucursalRepository;
import grupo3.LabFingeso.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehiculoService {
    @Autowired
    private vehiculoRepository vehiculoRepo;
    @Autowired
    private sucursalRepository sucursalRepo;

    public vehiculoService(vehiculoRepository vehiculoRepo, sucursalRepository sucursalRepo) {
        this.vehiculoRepo = vehiculoRepo;
        this.sucursalRepo = sucursalRepo;
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
        vehiculoEntity existenteVehiculo = vehiculoRepo.findById(nuevoVehiculo.getIdvehiculo()).orElse(null);
        if(existenteVehiculo != null){
            return null;
        }
        else{
            nuevoVehiculo.setSucursal(sucursalRepo.findByIdIfExist(nuevoVehiculo.getSucursal().getIdsucursal()));
            return vehiculoRepo.save(nuevoVehiculo);
        }
    }

    public vehiculoEntity getVehiculoById(long idVehiculo){
        return vehiculoRepo.findByIdIfExist(idVehiculo);
    }

    public vehiculoEntity updateVehiculo(long idVehiculoBase, vehiculoEntity vehiculoModificado){
        vehiculoEntity vehiculoBase = vehiculoRepo.findByIdIfExist(idVehiculoBase);
        if(vehiculoBase == null){
            System.out.println("Vehiculo NO actualizado");
            return null;
        }
        else{
            if (vehiculoModificado.getModelo() != null) {
                vehiculoBase.setModelo(vehiculoModificado.getModelo());
            }
            if (vehiculoModificado.getMatricula() != null) {
                vehiculoBase.setMatricula(vehiculoModificado.getMatricula());
            }
            if (vehiculoModificado.getTipo() != null) {
                vehiculoBase.setTipo(vehiculoModificado.getTipo());
            }
            if (vehiculoModificado.getKilometraje() >= 0) {
                vehiculoBase.setKilometraje(vehiculoModificado.getKilometraje());
            }
            if (vehiculoModificado.getEstado() != null) {
                vehiculoBase.setEstado(vehiculoModificado.getEstado());
            }
            if (vehiculoModificado.getPreciobase() > 0) {
                vehiculoBase.setPreciobase(vehiculoModificado.getPreciobase());
            }
            if (vehiculoModificado.getCategoria() != 0) {
                vehiculoBase.setCategoria(vehiculoModificado.getCategoria());
            }
            if (vehiculoModificado.getTransmision() != 0) {
                vehiculoBase.setTransmision(vehiculoModificado.getTransmision());
            }
            if (vehiculoModificado.getCombustible() != 0) {
                vehiculoBase.setCombustible(vehiculoModificado.getCombustible());
            }
            if (vehiculoModificado.getFotovehiculo() != null) {
                vehiculoBase.setFotovehiculo(vehiculoModificado.getFotovehiculo());
            }
            if (vehiculoModificado.getSucursal() != null) {
                vehiculoBase.setSucursal(vehiculoModificado.getSucursal());
            }
            System.out.println("Vehiculo actualizado");
            return vehiculoRepo.save(vehiculoBase);
        }
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
