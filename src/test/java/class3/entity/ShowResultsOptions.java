package class3.entity;

public enum ShowResultsOptions {
    FREE_RETURNS("s0-1-17-5[5]-[0]-LH_FR"),
    RETURNS_ACCEPTED("s0-1-17-5[5]-[1]-LH_RPA"),
    AUTHORIZED_SELLER("s0-1-17-5[5]-[2]-LH_AS"),
    DEALS_AND_SAVINGS("s0-1-17-5[5]-[3]-LH_Savings"),
    SALE_ITEMS("s0-1-17-5[5]-[4]-LH_SaleItems"),
    LISTED_AS_LOTS("s0-1-17-5[5]-[5]-LH_Lots"),
    BENEFITS_CHARITY("s0-1-17-5[5]-[6]-LH_Charity"),
    AUTHENTICITY_GUARANTEE("s0-1-17-5[5]-[7]-LH_AV"),
    ITEMS_WITH_PATTERN("s0-1-17-5[5]-[8]-LH_Time"),
    NUMBER_OF_BIDS("s0-1-17-5[5]-[9]-LH_NOB"),
    ITEMS_QUANTITY("s0-1-17-5[5]-[10]-LH_MIL");

    private String id;

    ShowResultsOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
