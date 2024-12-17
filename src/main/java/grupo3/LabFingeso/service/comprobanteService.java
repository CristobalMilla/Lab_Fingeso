package grupo3.LabFingeso.service;

import grupo3.LabFingeso.entity.comprobanteEntity;
import grupo3.LabFingeso.repository.comprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class comprobanteService {
    private final comprobanteRepository comprobanteRepo;

    @Autowired
    public comprobanteService(comprobanteRepository comprobanteRepo) {
        this.comprobanteRepo = comprobanteRepo;
    }

    // Create
    public comprobanteEntity save(comprobanteEntity comprobante) {
        return comprobanteRepo.save(comprobante);
    }

    // Read
    public comprobanteEntity findById(Long id) {
        return comprobanteRepo.findById(id).orElse(null);
    }

    public Iterable<comprobanteEntity> findAll() {
        return comprobanteRepo.findAll();
    }

    // Update
    public comprobanteEntity update(comprobanteEntity comprobante) {
        return comprobanteRepo.save(comprobante);
    }

    // Delete
    public void deleteById(Long id) {
        comprobanteRepo.deleteById(id);
    }
}
