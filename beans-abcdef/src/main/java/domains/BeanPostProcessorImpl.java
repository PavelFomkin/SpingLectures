package domains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof BeanF){
            System.out.println("postProcessBeforeInitialization was called for: " + s);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof BeanF){
            System.out.println("postProcessAfterInitialization was called for: " + s);
        }
        return o;
    }
}
