package domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class BeanC {
    String something;
    public abstract BeanD getBeanD();
}
