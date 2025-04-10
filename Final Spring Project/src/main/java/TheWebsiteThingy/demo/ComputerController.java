package TheWebsiteThingy.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public String newfoundInformation;
    @Autowired
    private TheWebsiteThingy.demo.Printers obj;
    @Autowired
    private TheWebsiteThingy.demo.ComputerService service;
    @PostMapping("/Computers")
    public ResponseEntity<String> getData(@RequestBody Computer comp){
        logger.info(comp.name);
        service.addComputer(comp);
        return new ResponseEntity<>("All Is Good!", HttpStatus.OK);
    }
    @GetMapping("/Computers/{id}")
    public ResponseEntity<Computer> getComputer(@PathVariable int id) {
        Computer comp = service.getComputer(id);
        if (comp != null) {
            return new ResponseEntity<>(comp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Computers/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable int id){
        service.deleteComputer(id);
    return new ResponseEntity<>("All is Good!", HttpStatus.OK);
    }
    @PutMapping("/Computers/{id}")
    public ResponseEntity<String> editComputer(@RequestBody Computer comp, @PathVariable int id){
        logger.info(comp.name);
        service.editComputer(comp,id);
        return new ResponseEntity<>("All Is Good!", HttpStatus.OK);
    }
    @GetMapping("/Computers/search")
    public ResponseEntity<List<Computer>> searchProducts(@RequestParam String brand) {

        List<Computer> Computers = service.searchComputers(brand);
        System.out.println("searching with " + brand);
        return new ResponseEntity<>(Computers, HttpStatus.OK);
    }


}
