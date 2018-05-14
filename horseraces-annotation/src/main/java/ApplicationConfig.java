import domains.*;
import domains.interfaces.MemberOfRace;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import services.EmulationServiceImpl;
import services.RaceServiceImpl;
import services.interfaces.EmulationService;
import services.interfaces.RaceService;

@Configuration
public class ApplicationConfig {

    public static final int LENGTH_OF_RACE = 300;
    public static final int UPDATE_FREQUENCY_IN_SECONDS = 3;

    @Bean
    public Rider pavel() {
        return Rider.builder().firstName("Pavel").lastName("Fomkin").age(27).weight(70).skill(RiderSkill.PRO).build();
    }

    @Bean
    public Rider ivan() {
        return Rider.builder().firstName("Ivan").lastName("Ivanov").age(22).weight(65).skill(RiderSkill.MASTER).build();
    }

    @Bean
    public Rider petr() {
        return Rider.builder().firstName("Petr").lastName("Petrov").age(32).weight(75).skill(RiderSkill.PRO).build();
    }

    @Bean
    public Breed breed1() {
        return Breed.builder().name("SuperFast").maxSpeed(90).build();
    }

    @Bean
    public Breed breed2() {
        return Breed.builder().name("Fast").maxSpeed(80).build();
    }

    @Bean
    public Horse summer() {
        return Horse.builder().name("Summer").age(2).breed(breed1()).build();
    }

    @Bean
    public Horse spring() {
        return Horse.builder().name("Spring").age(3).breed(breed1()).build();
    }

    @Bean
    public Horse winter() {
        return Horse.builder().name("Winter").age(3).breed(breed2()).build();
    }

    @Bean
    public MemberOfRace member1() {
        return MemberOfRaceImpl.builder().maxExtraSpeedForLuck(30).horse(spring()).rider(pavel()).build();
    }

    @Bean
    public MemberOfRace member2() {
        return MemberOfRaceImpl.builder().maxExtraSpeedForLuck(30).horse(winter()).rider(ivan()).build();
    }

    @Bean
    public MemberOfRace member3() {
        return MemberOfRaceImpl.builder().maxExtraSpeedForLuck(30).horse(summer()).rider(petr()).build();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RaceService raceService() {
        return RaceServiceImpl.builder().lengthOfRace(LENGTH_OF_RACE).build();
    }

    @Bean
    public EmulationService emulationService() {
        return EmulationServiceImpl.builder().updateFrequencyInSeconds(UPDATE_FREQUENCY_IN_SECONDS).build();
    }
}
