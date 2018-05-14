package domains;

public enum RiderSkill {

    PRO(1.0), MASTER(0.95), FAN(0.85), OUTSIDER(0.7);

    Double multiplier;

    RiderSkill(Double skill) {
        this.multiplier = skill;
    }

    public Double getMultiplier() {
        return multiplier;
    }
}
