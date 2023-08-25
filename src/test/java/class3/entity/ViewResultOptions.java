package class3.entity;

public enum ViewResultOptions {
    LIST_VIEW("List view"),
    GALLERY_VIEW("Gallery view");

    private String value;

    ViewResultOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
