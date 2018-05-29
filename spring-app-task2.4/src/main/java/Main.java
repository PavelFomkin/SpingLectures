import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import services.BeanFactoryService;
import services.ServiceWrapper;
import services.SingletonAndPrototypeService;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ServiceWrapper service = context.getBean("wrapper", ServiceWrapper.class);
        service.getService().doSomething();
        service.getService2().doNothing();
        System.out.println("Entity from file: " + service.getEntity().getName());
        System.out.println("Url from file: " + service.getDbUrl());
        System.out.println("DbHost from file: " + service.getDbHost());
        System.out.println("DbLogin from file: " + service.getDbLogin());
        System.out.println("DbPassword from file: " + service.getDbPassword());

        SingletonAndPrototypeService service2 = context.getBean("singletonAndPrototypeService",
                SingletonAndPrototypeService.class);
        System.out.println("service2 fields: singleton = " + service2.getSingletonEntity().getRandom() +
                "\t prototype = " + service2.getPrototypeEntity().getRandom());

        SingletonAndPrototypeService service3 = context.getBean("singletonAndPrototypeService",
                SingletonAndPrototypeService.class);
        System.out.println("service3 fields: singleton = " + service3.getSingletonEntity().getRandom() +
                "\t prototype = " + service3.getPrototypeEntity().getRandom());

        BeanFactoryService service4 = context.getBean("beanFactoryService", BeanFactoryService.class);
        System.out.println(service4.createBean("bean 1"));
        System.out.println(service4.createBean("bean 2"));
    }
}
