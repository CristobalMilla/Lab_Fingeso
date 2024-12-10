package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.pagoEntity;
import grupo3.LabFingeso.repository.pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pagoService {
    @Autowired
    pagoRepository pagoRepo;

    public pagoEntity guardaPago(pagoEntity pago){
        return pagoRepo.save(pago);
    }

}
