package domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rider {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer weight;
    private RiderSkill skill;

    public Double getMultiplierOfSpeed() {
        return getAgeMultiplier()*getWeightMultiplier()*skill.getMultiplier();
    }

    private Double getAgeMultiplier(){
        if (age >= 18 && age < 25) {
            return 0.95;
        } else if (age >= 25 && age < 30) {
            return 1.0;
        } else if (age >= 30 && age < 40) {
            return 0.95;
        } else if (age <= 50) {
            return 0.85;
        } else {
            return 0.8;
        }
    }

    private Double getWeightMultiplier(){
        if (weight <= 50) {
            return 0.9;
        } else if (weight <= 60) {
            return 0.85;
        } else if (weight <= 70) {
            return 0.75;
        } else if (weight <= 80) {
            return 0.7;
        } else {
            return 0.65;
        }
    }
}
