package part2.domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeanWithParameters {
    private String name;
    private int age;
    private SingletonBean trueFriend;

    public BeanWithParameters(String name, int age, SingletonBean trueFriend) {
        this.name = name;
        this.age = age;
        this.trueFriend = trueFriend;
    }

    private String description;
}
