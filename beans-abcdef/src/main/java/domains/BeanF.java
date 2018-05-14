package domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BeanF {
    String name;

    void init(){
        System.out.println("Method initialization was called for BeanF");
    }

    void destroy(){
        System.out.println("Method destroy was called for BeanF");
    }
}
