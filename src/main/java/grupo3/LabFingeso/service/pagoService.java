package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.pagoEntity;
import grupo3.LabFingeso.repository.pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pagoService {
    @Autowired
    private pagoRepository pagoRepo;
    
    public pagoService(pagoRepository pagoRepo) {
        this.pagoRepo = pagoRepo;
    }

    // Create
    public pagoEntity createPago(pagoEntity pago) {
        pagoEntity existentePago = pagoRepo.findById(pago.getId()).orElse(null);
        if(existentePago != null) {
            return null;
        }
        else {
            return pagoRepo.save(pago);
        }
    }

    // Read
    public pagoEntity getPagoById(Long id) {
        return pagoRepo.findById(id).orElse(null);
    }

    public List<pagoEntity> getAllPagos() {
        return pagoRepo.findAll();
    }

    // Update
    public pagoEntity updatePago(pagoEntity pago) {
        return pagoRepo.save(pago);
    }

    // Delete
    public void deletePagoById(Long id) {
        pagoRepo.deleteById(id);
    }
}
