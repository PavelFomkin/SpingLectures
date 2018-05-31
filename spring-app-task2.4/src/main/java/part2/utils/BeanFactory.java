package part2.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import part2.domains.PrototypeBean;

@Getter
@Setter
@NoArgsConstructor
public class BeanFactory{

    public PrototypeBean createBean() {
        return new PrototypeBean("I am a new bean.");
    }
}
