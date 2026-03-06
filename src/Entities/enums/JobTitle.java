package Entities.enums;

public enum JobTitle {
    SELLER("1"),
    HR("2"),
    MECHANIC("3"),
    MANAGER("4");

    private String accessLevel;

    JobTitle(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}