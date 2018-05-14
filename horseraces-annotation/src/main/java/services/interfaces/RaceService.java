package services.interfaces;

import domains.interfaces.MemberOfRace;

import java.util.List;

public interface RaceService {

    void info();

    void addMember(MemberOfRace member);

    void deleteMember(MemberOfRace member);

    List<MemberOfRace> getMembers();

    Integer getLengthOfRace();
}
