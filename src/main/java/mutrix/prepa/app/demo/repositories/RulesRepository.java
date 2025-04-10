package mutrix.prepa.app.demo.repositories;

import mutrix.prepa.app.demo.entities.Rules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RulesRepository extends JpaRepository<Rules, Long> {
    Rules findByName(String name);
}
