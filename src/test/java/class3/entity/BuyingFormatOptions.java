package class3.entity;

public enum BuyingFormatOptions {
    ACCEPT_OFFERS("s0-1-17-6[3]-[0]-LH_BO"),
    AUCTION("s0-1-17-6[3]-[1]-LH_Auction"),
    BUY_NOW("s0-1-17-6[3]-[2]-LH_BIN"),
    CLASSIFIED_ADS("s0-1-17-6[3]-[3]-LH_CAds");
    private String id;

    BuyingFormatOptions(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
