package TheWebsiteThingy.demo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepo repo;

    public void addComputer(Computer comp) {
        repo.save(comp);
    }

    public Computer getComputer(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteComputer(int id) {
        repo.deleteById(id);
    }

    public void editComputer(Computer comp, int id) {
        Optional<Computer> existingComp = repo.findById(id);
        if (existingComp.isPresent()) {
            Computer updatedComp = existingComp.get();
            BeanUtils.copyProperties(comp, updatedComp, "id");
            repo.save(updatedComp);
        }
    }
}
