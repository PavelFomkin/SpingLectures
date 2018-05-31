package part1.utils;

import part1.domains.PrototypeEntity;
import part1.domains.SingletonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
@Scope("prototype")
public class SingletonAndPrototypeService {
    SingletonEntity singletonEntity;
    PrototypeEntity prototypeEntity;

    @Autowired
    public SingletonAndPrototypeService(SingletonEntity singletonEntity, PrototypeEntity prototypeEntity) {
        this.singletonEntity = singletonEntity;
        this.prototypeEntity = prototypeEntity;
    }
}
