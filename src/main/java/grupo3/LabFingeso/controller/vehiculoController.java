package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.service.vehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin
public class vehiculoController {
    @Autowired
    private vehiculoService serviceVehiculo;

    @PutMapping("/cambiarDisponibilidad")
    public vehiculoEntity cambiarDisponibilidad(@RequestParam long idVehiculo, String estado){
        return serviceVehiculo.cambiarDisponibilidad(idVehiculo, estado);
    }

    @PostMapping("/crearVehiculo")
    public vehiculoEntity crearVehiculo(@RequestBody vehiculoEntity nuevoVehiculo) {
        return serviceVehiculo.createVehiculo(nuevoVehiculo);
    }

    @GetMapping("/obtenerVehiculo/{idVehiculo}")
    public vehiculoEntity getVehiculoById(@PathVariable long idVehiculo){
        return serviceVehiculo.getVehiculoById(idVehiculo);
    }

    @GetMapping("/obtenerTodos")
    public List<vehiculoEntity> getVehiculos(){
        return serviceVehiculo.getAllVehiculos();
    }

    @PutMapping("/actualizarVehiculo")
    public vehiculoEntity updateVehiculo(@RequestBody vehiculoEntity vehiculoModificado){
        return serviceVehiculo.updateVehiculo(vehiculoModificado);
    }

    @DeleteMapping("/eliminarVehiculo")
    public boolean eliminateVehiculoById(@RequestParam long idVehiculo){
        return serviceVehiculo.eliminateVehiculoById(idVehiculo);
    }
}
