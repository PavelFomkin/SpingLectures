package domains;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ActionReplacer implements MethodReplacer{
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("I am an another person (the method was replaced).");

        return null;
    }
}
