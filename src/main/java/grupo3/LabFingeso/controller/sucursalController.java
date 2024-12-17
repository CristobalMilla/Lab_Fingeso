package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.sucursalEntity;
import grupo3.LabFingeso.service.sucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
@CrossOrigin
public class sucursalController {
    @Autowired
    private sucursalService serviceSucursal;

    @PostMapping("/crearSucursal")
    public sucursalEntity createSucursal(@RequestBody sucursalEntity nuevaSucursal){
        return serviceSucursal.createSucursal(nuevaSucursal);
    }

    @GetMapping("/obtenerSucursal/{idSucursal}")
    public sucursalEntity getSucursalById(@PathVariable long idSucursal){
        return serviceSucursal.getSucursalById(idSucursal);
    }

    @GetMapping("/obtenerTodas")
    public List<sucursalEntity> getAllSucursales(){
        return serviceSucursal.getAllSucursales();
    }

    @PutMapping("/actualizarSucursal")
    public sucursalEntity updateSucursal(@RequestBody sucursalEntity sucursalModificada){
        return serviceSucursal.updateSucursal(sucursalModificada);
    }

    @DeleteMapping("/eliminarSucursal")
    public boolean eliminateSucursalById(@RequestParam long idSucursal){
        return serviceSucursal.eliminateSucursalById(idSucursal);
    }
}
