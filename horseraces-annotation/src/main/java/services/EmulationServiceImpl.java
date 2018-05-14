package services;

import domains.interfaces.MemberOfRace;
import lombok.*;
import org.springframework.stereotype.Service;
import services.interfaces.EmulationService;
import services.interfaces.RaceService;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Service
public class EmulationServiceImpl implements EmulationService {

    private Integer updateFrequencyInSeconds;

    private RaceService raceService;

    private MemberOfRace bet;

    public void chooseMemberByName(String horseName) {
        for (MemberOfRace member : raceService.getMembers()) {
            if (member.getName().equalsIgnoreCase(horseName)) {
                bet = member;
            }
        }
        if (bet == null) {
            System.out.println("Horse name is wrong.");
        }
    }

    public void start() {
        Map<MemberOfRace, Double> results = new HashMap<>();
        for (MemberOfRace member : raceService.getMembers()) {
            results.put(member, 0.0);
        }
        if (results.size() == 0) {
            System.out.println("We have no members.");
            return;
        }
        System.out.println("-----START-----");
        boolean finish = false;
        while (!finish) {
            System.out.println("-----CURRENT POSITIONS-----");
            for (Map.Entry<MemberOfRace, Double> entry : results.entrySet()) {
                entry.setValue(entry.getValue() + entry.getKey().runDistanceFor(updateFrequencyInSeconds));
                System.out.println(entry.getKey().getName() + ", distance: "
                        + String.format("%.2f", entry.getValue()) + " meters");
                if (entry.getValue() >= raceService.getLengthOfRace()) {
                    finish = true;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----FINISH-----");
        MemberOfRace winner = getWinner(results);
        System.out.println("Winner is " + winner.getName());
        if (bet != null) {
            if (winner.equals(bet)) {
                System.out.println("The bet played, congratulations!");
            } else {
                System.out.println("You lose, the bet was wrong!");
            }
        }
    }

    private MemberOfRace getWinner(Map<MemberOfRace, Double> results) {
        Double bestDistance = 0.0;
        MemberOfRace winner = null;
        for (Map.Entry<MemberOfRace, Double> entry : results.entrySet()) {
            if (entry.getValue() > bestDistance) {
                bestDistance = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }
}
