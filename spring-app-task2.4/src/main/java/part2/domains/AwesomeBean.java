package part2.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AwesomeBean {
    private String username;

    void init(){
        System.out.println("Awesome bean is alive! init()");
    }

    void destroy(){
        System.out.println("Awesome bean is dead! destroy()");
    }
}
