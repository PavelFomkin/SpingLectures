package services;

import domains.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class BeanFactoryService {

    public Entity createBean(String entityName){
        return new Entity(entityName);
    }
}
