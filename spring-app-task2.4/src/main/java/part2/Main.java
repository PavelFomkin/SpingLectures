package part2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import part2.domains.AwesomeBean;
import part2.domains.BeanWithParameters;
import part2.domains.PrototypeBean;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        PrototypeBean factoryBean1 = context.getBean("factoryBean1", PrototypeBean.class);
        System.out.println(factoryBean1);
        PrototypeBean factoryBean2 = context.getBean("factoryBean2", PrototypeBean.class);
        System.out.println(factoryBean2);

        BeanWithParameters beanWithParameters = context.getBean(BeanWithParameters.class);
        System.out.println("Name: " + beanWithParameters.getName());
        System.out.println("Age: " + beanWithParameters.getAge());
        System.out.println("True friend: " + beanWithParameters.getTrueFriend().getName());

        AwesomeBean bean = context.getBean("awesomeBean", AwesomeBean.class);
        System.out.println(bean.getUsername());
    }
}
