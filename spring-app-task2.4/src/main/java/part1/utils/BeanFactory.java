package part1.utils;

import part1.domains.NoBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class BeanFactory implements FactoryBean<NoBean>{

    @Override
    public NoBean getObject() throws Exception {
        return new NoBean("I am a new bean.");
    }

    @Override
    public Class<NoBean> getObjectType() {
        return NoBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
