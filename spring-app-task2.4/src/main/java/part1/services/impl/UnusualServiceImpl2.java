package part1.services.impl;

import org.springframework.stereotype.Service;
import part1.services.UnusualService;

@Service
public class UnusualServiceImpl2 implements UnusualService{

    @Override
    public void doNothing() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }
}
