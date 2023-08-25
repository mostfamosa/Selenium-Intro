package class3.entity;

public enum Pattern {
    ENDING_WITHIN("Ending within"),
    ENDING_IN_MORE_THAN("Ending in more than"),
    STARTED_WITHIN("Started within");

    private String value;

    Pattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
