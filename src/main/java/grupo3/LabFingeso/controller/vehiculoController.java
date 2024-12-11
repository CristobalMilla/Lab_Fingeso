package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.vehiculoEntity;
import grupo3.LabFingeso.service.vehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin
public class vehiculoController {
    @Autowired
    private vehiculoService serviceVehiculo;

    @PostMapping("/crearVehiculo")
    public vehiculoEntity crearVehiculo(@RequestBody vehiculoEntity nuevoVehiculo) {
        return serviceVehiculo.crearVehiculo(nuevoVehiculo.getidVehiculo(), nuevoVehiculo.getMarca(), nuevoVehiculo.getModelo(),
                nuevoVehiculo.getMatricula(), nuevoVehiculo.getTipo(), nuevoVehiculo.getKilometraje(), nuevoVehiculo.getEstado(),
                nuevoVehiculo.getSucursal(), nuevoVehiculo.getPrecioBase());
    }

    @PostMapping("/eliminarVehiculo")
    public boolean eliminarVehiculo(@RequestBody vehiculoEntity nuevoVehiculo){
        return serviceVehiculo.eliminarVehiculo(nuevoVehiculo.getidVehiculo());
    }
}
