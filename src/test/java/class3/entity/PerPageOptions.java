package class3.entity;

public enum PerPageOptions {
    PER_PAGE_60("60"),
    PER_PAGE_120("120"),
    PER_PAGE_240("240");

    private String value;

    PerPageOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
