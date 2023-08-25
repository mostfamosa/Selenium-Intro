package class3.entity;

public enum PatternTime {

    HOUR_1("1 hour"),
    HOUR_2("2 hours"),
    HOUR_3("3 hours"),
    HOUR_4("4 hours"),
    HOUR_5("5 hours"),
    HOUR_12("12 hours"),
    HOUR_24("24 hours"),
    DAY_2("2 days"),
    DAY_3("3 days"),
    DAY_4("4 days"),
    DAY_5("5 days"),
    DAY_6("6 days"),
    DAY_7("7 days");

    private String value;

    PatternTime(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
