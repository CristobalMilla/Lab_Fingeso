package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.pagoEntity;
import grupo3.LabFingeso.repository.pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pagoService {
    private final pagoRepository pagoRepo;

    @Autowired
    public pagoService(pagoRepository pagoRepo) {
        this.pagoRepo = pagoRepo;
    }

    // Create
    public pagoEntity save(pagoEntity pago) {
        return pagoRepo.save(pago);
    }

    // Read
    public pagoEntity findById(Long id) {
        return pagoRepo.findById(id).orElse(null);
    }

    public Iterable<pagoEntity> findAll() {
        return pagoRepo.findAll();
    }

    // Update
    public pagoEntity update(pagoEntity pago) {
        return pagoRepo.save(pago);
    }

    // Delete
    public void deleteById(Long id) {
        pagoRepo.deleteById(id);
    }
}
