package part1.services.impl;

import org.springframework.stereotype.Service;
import part1.services.UsualService;

@Service
public class UsualServiceImpl implements UsualService{

    @Override
    public void doSomething() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }

    @Override
    public void doSomethingElse() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }
}
