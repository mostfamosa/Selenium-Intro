package class3.entity;

public enum LocationByMiles {
    MILES_10("10"),
    MILES_25("25"),
    MILES_50("50"),
    MILES_100("100"),
    MILES_200("200"),
    MILES_500("500"),
    MILES_1000("1000");

    private String value;

    LocationByMiles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
