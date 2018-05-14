package domains;

import domains.interfaces.MemberOfRace;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class MemberOfRaceImpl implements MemberOfRace {

    private int maxExtraSpeedForLuck;
    Horse horse;
    Rider rider;

    @Override
    public Double runDistanceFor(Integer seconds) {
        return (getHorseSpeed() / 3.6) * seconds;
    }

    @Override
    public String getName() {
        return horse.getName();
    }

    private Double getHorseSpeed() {
        return (horse.getMaxSpeed() * rider.getMultiplierOfSpeed()) + getLuck();
    }

    private Double getLuck() {
        return Math.random() * maxExtraSpeedForLuck;
    }
}
