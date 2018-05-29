import domains.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import services.BeanFactoryService;
import services.ServiceWrapper;
import services.SingletonAndPrototypeService;
import services.UsualService;
import services.impl.UnusualServiceImpl;
import services.impl.UnusualServiceImpl2;
import services.impl.UsualServiceImpl;
import services.impl.UsualServiceImpl2;

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
    public BeanFactoryService beanFactoryService() {
        return new BeanFactoryService();
    }

}
