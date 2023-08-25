package class3.entity;

public enum SearchIncludeOptions {
    TITLE_AND_DESCRIPTION("s0-1-17-5[1]-[0]-LH_TitleDesc"),
    COMPLETED_ITEMS("s0-1-17-5[1]-[1]-LH_Complete"),
    SOLD_ITEMS("s0-1-17-5[1]-[2]-LH_Sold");

    private String id;

    SearchIncludeOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
