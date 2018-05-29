package services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.UsualService;

@Service
public class UsualServiceImpl2 implements UsualService {

    @Override
    public void doSomething() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }

    @Override
    public void doSomethingElse() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }
}
