package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.service.vehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin
public class vehiculoController {

    private vehiculoService serviceVehiculo;

    @Autowired
    public vehiculoController(vehiculoService serviceVehiculo) {
        this.serviceVehiculo = serviceVehiculo;
    }

    @PostMapping("/crearVehiculo")
    public vehiculoEntity crearVehiculo(@RequestBody vehiculoEntity nuevoVehiculo) {
        return serviceVehiculo.createVehiculo(nuevoVehiculo);
    }

    @GetMapping("/obtenerVehiculo")
    public vehiculoEntity getVehiculoById(@PathVariable long idVehiculo){
        return serviceVehiculo.getVehiculoById(idVehiculo);
    }

    @GetMapping("/obtenerTodosVehiculos")
    public List<vehiculoEntity> getVehiculoById(){
        return serviceVehiculo.getAllVehiculos();
    }

    @PutMapping("/actualizarVehiculo")
    public vehiculoEntity updateVehiculo(vehiculoEntity vehiculoModificado){
        return serviceVehiculo.updateVehiculo(vehiculoModificado);
    }

    @DeleteMapping("/eliminarVehiculo")
    public boolean eliminateVehiculo(@RequestBody vehiculoEntity nuevoVehiculo){
        return serviceVehiculo.eliminateVehiculo(nuevoVehiculo.getidVehiculo());
    }
}
