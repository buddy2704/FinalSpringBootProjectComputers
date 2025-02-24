package TheWebsiteThingy.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepo extends JpaRepository<Computer, Integer> {
    @Query("SELECT p from Computer p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.cpu) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.gpu) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Computer> searchComputers(String keyword);

}
