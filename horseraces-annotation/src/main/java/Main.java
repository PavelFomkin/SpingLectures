import domains.MemberOfRaceImpl;
import domains.interfaces.MemberOfRace;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.EmulationServiceImpl;
import services.RaceServiceImpl;
import services.interfaces.EmulationService;
import services.interfaces.RaceService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberOfRace member1 = context.getBean("member1", MemberOfRaceImpl.class);
        MemberOfRace member2 = context.getBean("member2", MemberOfRaceImpl.class);
        MemberOfRace member3 = context.getBean("member3", MemberOfRaceImpl.class);

        RaceService race = context.getBean("raceService", RaceServiceImpl.class);
        race.addMember(member1);
        race.addMember(member2);
        race.addMember(member3);
        race.info();

        EmulationService emulator = context.getBean("emulationService", EmulationServiceImpl.class);
        emulator.setRaceService(race);
        emulator.chooseMemberByName("Summer");
        emulator.start();
    }

}
