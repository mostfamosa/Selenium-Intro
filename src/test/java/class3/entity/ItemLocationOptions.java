package class3.entity;

public enum ItemLocationOptions {
    DEFAULT("s0-1-17-6[7]-[0]-LH_PrefLoc"),
    ITEMS_WITHIN("s0-1-17-6[7]-[1]-LH_PrefLoc"),
    US_ONLY("s0-1-17-6[7]-[2]-LH_PrefLoc"),
    NORTH_AMERICA("s0-1-17-6[7]-[3]-LH_PrefLoc"),
    WORLDWIDE("s0-1-17-6[7]-[4]-LH_PrefLoc"),
    LOCATED_IN("s0-1-17-6[7]-[5]-LH_LocatedIn"),
    AVAILABLE_TO("s0-1-17-6[7]-[6]-LH_AvailTo");

    private String id;

    ItemLocationOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
