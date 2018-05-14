import domains.interfaces.MemberOfRace;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.interfaces.EmulationService;
import services.interfaces.RaceService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        MemberOfRace member1 = context.getBean("member1", MemberOfRace.class);
        MemberOfRace member2 = context.getBean("member2", MemberOfRace.class);
        MemberOfRace member3 = context.getBean("member3", MemberOfRace.class);

        RaceService race = context.getBean("raceService", RaceService.class);

        race.addMember(member1);
        race.addMember(member2);
        race.addMember(member3);

        race.info();

        EmulationService emulator = context.getBean("emulationService", EmulationService.class);

        emulator.chooseMemberByName("Spring");

        emulator.start();
    }

}
