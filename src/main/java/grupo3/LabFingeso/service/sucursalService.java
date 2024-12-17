package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.sucursalEntity;
import grupo3.LabFingeso.repository.sucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sucursalService {
    @Autowired
    private sucursalRepository sucursalRepo;

    public sucursalService(sucursalRepository sucursalRepo) {
        this.sucursalRepo = sucursalRepo;
    }

    public sucursalEntity createSucursal(sucursalEntity nuevaSucursal){
        sucursalEntity existenteSucursal = sucursalRepo.findById(nuevaSucursal.getIdsucursal()).orElse(null);
        if(existenteSucursal != null){
            return null;
        }
        else{
            return sucursalRepo.save(nuevaSucursal);
        }
    }

    public sucursalEntity getSucursalById(long idSucursal){
        return sucursalRepo.findByIdIfExist(idSucursal);
    }

    public List<sucursalEntity> getAllSucursales(){
        return sucursalRepo.findAll();
    }

    public sucursalEntity updateSucursal(sucursalEntity sucursalModificada){
        return sucursalRepo.save(sucursalModificada);
    }

    public boolean eliminateSucursalById(long idSucursal){
        if(sucursalRepo.findById(idSucursal).orElse(null) != null){
            try {
                sucursalRepo.deleteById(idSucursal);
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
