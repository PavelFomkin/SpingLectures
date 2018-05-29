package services;

import domains.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
public class ServiceWrapper {

    @Autowired
    private Entity entity;

    @Value("${config.database.url}")
    private String dbUrl;
    @Value("${config.database.host}")
    private String dbHost;
    @Value("${config.database.login}")
    private String dbLogin;
    @Value("${config.database.password}")
    private List<String> dbPassword;

    private UsualService service;
    private UnusualService service2;

    @Autowired
    public ServiceWrapper(UsualService service) {
        this.service = service;
    }

    @Autowired
    @Qualifier("unusualService")
    public void setService2(UnusualService service2){
        this.service2 = service2;
    }
}
