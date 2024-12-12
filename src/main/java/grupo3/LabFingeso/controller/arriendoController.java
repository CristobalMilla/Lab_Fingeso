package grupo3.LabFingeso.controller;

import grupo3.LabFingeso.entity.arriendoEntity;
import grupo3.LabFingeso.service.arriendoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arriendo")
@CrossOrigin
public class arriendoController {
    @Autowired
    private arriendoService serviceArriendo;
    
    @PostMapping("/crearArriendo")
    public arriendoEntity createArriendo(@RequestBody arriendoEntity nuevoArriendo){
        return serviceArriendo.createArriendo(nuevoArriendo);
    }

    @GetMapping("/obtenerArriendo/{idArriendo}")
    public arriendoEntity getArriendoById(@PathVariable long idArriendo){
        return serviceArriendo.getArriendoById(idArriendo);
    }

    @GetMapping("/obtenerTodos")
    public List<arriendoEntity> getAllArriendos(){
        return serviceArriendo.getAllArriendos();
    }

    @PutMapping("/actualizarArriendo")
    public arriendoEntity updateArriendo(@RequestBody arriendoEntity arriendoModificado){
        return serviceArriendo.updateArriendo(arriendoModificado);
    }

    @DeleteMapping("/eliminarArriendo")
    public boolean eliminateArriendoById(@RequestParam long idArriendo){
        return serviceArriendo.eliminateArriendoById(idArriendo);
    }
}
