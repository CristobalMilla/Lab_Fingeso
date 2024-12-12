package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.repository.arriendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class arriendoService {
    @Autowired
    private arriendoRepository arriendoRepo;

    public arriendoService(arriendoRepository arriendoRepo) {
        this.arriendoRepo = arriendoRepo;
    }

    public arriendoEntity createArriendo(arriendoEntity nuevoArriendo) {
        arriendoEntity existenteArriendo = arriendoRepo.findById(nuevoArriendo.getIdArriendo()).orElse(null);
        if(existenteArriendo != null){
            return null;
        }
        else{
            return arriendoRepo.save(nuevoArriendo);
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
