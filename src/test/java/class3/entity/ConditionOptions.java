package class3.entity;

public enum ConditionOptions {
    NEW("s0-1-17-6[4]-[0]-LH_ItemCondition"),
    USED("s0-1-17-6[4]-[1]-LH_ItemCondition"),
    NOT_SPECIFIED("s0-1-17-6[4]-[2]-LH_ItemCondition");
    private String id;

    ConditionOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
