package services;

import domains.interfaces.MemberOfRace;
import lombok.*;
import org.springframework.stereotype.Service;
import services.interfaces.RaceService;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Service
public class RaceServiceImpl implements RaceService {

    private final List<MemberOfRace> members = new ArrayList<>();

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
