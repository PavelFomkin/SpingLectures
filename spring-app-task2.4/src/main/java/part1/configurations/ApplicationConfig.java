package part1.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import part1.domains.Entity;
import part1.domains.PrototypeEntity;
import part1.domains.SingletonEntity;
import part1.utils.BeanFactory;
import part1.utils.ServiceWrapper;
import part1.utils.SingletonAndPrototypeService;
import part1.services.UsualService;
import part1.services.impl.UnusualServiceImpl;
import part1.services.impl.UnusualServiceImpl2;
import part1.services.impl.UsualServiceImpl;
import part1.services.impl.UsualServiceImpl2;

@Configuration
@PropertySource("app.properties")
public class ApplicationConfig {

    @Bean
    public Entity entity() {
        return new Entity("Pavel");
    }

    @Bean()
    @Scope("prototype")
    public PrototypeEntity prototypeEntity() {
        return new PrototypeEntity();
    }

    @Bean()
    public SingletonEntity singletonEntity() {
        return new SingletonEntity();
    }

    @Bean("usualService")
    public UsualServiceImpl usualService() {
        return new UsualServiceImpl();
    }

    @Bean("usualService2")
    public UsualServiceImpl2 usualService2() {
        return new UsualServiceImpl2();
    }

    @Bean("unusualService")
    public UnusualServiceImpl unusualService() {
        return new UnusualServiceImpl();
    }

    @Bean("unusualService2")
    public UnusualServiceImpl2 unusualService2() {
        return new UnusualServiceImpl2();
    }

    @Bean("wrapper")
    public ServiceWrapper wrapper(@Qualifier("usualService") UsualService service) {
        return new ServiceWrapper(service);
    }

    @Bean("singletonAndPrototypeService")
    @Scope("prototype")
    public SingletonAndPrototypeService singletonAndPrototypeExample(SingletonEntity singletonEntity, PrototypeEntity prototypeEntity) {
        return new SingletonAndPrototypeService(singletonEntity, prototypeEntity);
    }

    @Bean("beanFactoryService")
    public BeanFactory beanFactoryService() {
        return new BeanFactory();
    }

}
