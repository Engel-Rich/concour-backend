package mutrix.prepa.app.demo.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mutrix.prepa.app.demo.entities.Rules;
import mutrix.prepa.app.demo.repositories.RulesRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RulesService {
    private  RulesRepository rulesRepository;

    public Rules saveRules(String name, String description) {
        if (rulesRepository.findByName(name) == null) {
        return     rulesRepository.save(new Rules(name, description));
        } else {
            throw new IllegalArgumentException("Rule already exists");
        }
    }

    public Rules findByName(String name) {
        return rulesRepository.findByName(name);
    }
     public Rules findById(Long id) {
        return rulesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Rule not found"));
    }



}
