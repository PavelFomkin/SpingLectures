package services.interfaces;

public interface EmulationService {

    void chooseMemberByName(String horseName);

    void start();

    void setRaceService(RaceService raceService);
}
