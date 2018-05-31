package part1.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@Component
public class SingletonEntity{
    private Integer random = new Random().nextInt(1000);
}
