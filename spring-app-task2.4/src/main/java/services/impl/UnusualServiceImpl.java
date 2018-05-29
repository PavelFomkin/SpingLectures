package services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.UnusualService;

@Service
public class UnusualServiceImpl implements UnusualService{

    @Override
    public void doNothing() {
        System.out.println("I'm an " + this.getClass().getSimpleName());
    }
}
