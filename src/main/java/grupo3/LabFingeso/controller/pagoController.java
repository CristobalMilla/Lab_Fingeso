package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.pagoEntity;
import grupo3.LabFingeso.entity.sucursalEntity;
import grupo3.LabFingeso.service.pagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
@CrossOrigin
public class pagoController {
    @Autowired
    private pagoService servicePago;

    @PostMapping("/crearPago")
    public pagoEntity createPago(@RequestBody pagoEntity nuevoPago){
        return servicePago.createPago(nuevoPago);
    }

    @GetMapping("/obtenerPago/{id}")
    public pagoEntity getPagoById(@PathVariable Long id){
        return servicePago.getPagoById(id);
    }

    @GetMapping("/obtenerTodosPagos")
    public List<pagoEntity> getAllPagos(){
        return servicePago.getAllPagos();
    }


    @DeleteMapping("/eliminarPago")
    public void deletePagoById(@RequestParam Long id){
        servicePago.deletePagoById(id);
    }
}
