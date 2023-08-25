package class3.entity;

public enum ShippingOptions {
    FREE_SHIPPING("s0-1-17-5[6]-[0]-LH_FS"),
    LOCAL_SHIPPING("s0-1-17-5[6]-[1]-LH_LPickup");

    private String id;

    ShippingOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
