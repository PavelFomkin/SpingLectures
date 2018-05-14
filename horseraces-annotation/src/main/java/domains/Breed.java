package domains;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Component
public class Breed {
    private String name;
    private Integer maxSpeed;
}
