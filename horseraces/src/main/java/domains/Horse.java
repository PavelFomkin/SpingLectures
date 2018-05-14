package domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Horse {
    private String name;
    private Integer age;
    private Breed breed;

    public Double getMaxSpeed(){
        return breed.getMaxSpeed()*getMultiplierOfSpeed();
    }

    private Double getMultiplierOfSpeed() {
        if (age >= 1 && age < 3) {
            return 1.0;
        } else if (age >= 3 && age < 5) {
            return 0.95;
        } else if (age >= 5 && age < 7) {
            return 0.85;
        } else if (age < 10) {
            return 0.7;
        } else {
            return 0.6;
        }
    }
}
