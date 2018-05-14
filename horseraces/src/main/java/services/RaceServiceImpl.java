package services;

import domains.interfaces.MemberOfRace;
import lombok.*;
import services.interfaces.RaceService;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RaceServiceImpl implements RaceService {

    private List<MemberOfRace> members = new ArrayList<>();

    private Integer lengthOfRace;

    public void info() {
        System.out.println("Count of participants: " + members.size());
        for (MemberOfRace participant : members) {
            System.out.println(participant);
        }
        System.out.println("Length of the track: " + lengthOfRace);
    }

    public void addMember(MemberOfRace member) {
        members.add(member);
    }

    public void deleteMember(MemberOfRace member) {
        members.remove(member);
    }
}
