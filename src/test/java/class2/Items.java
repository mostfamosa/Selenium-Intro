package class2;

public enum Items {
    Sauce_Labs_Backpack("add-to-cart-sauce-labs-backpack","remove-sauce-labs-backpack"),
    Sauce_Labs_Bike_Light("add-to-cart-sauce-labs-bike-light","remove-sauce-labs-bike-light"),
    Sauce_Labs_Bolt_TShirt("add-to-cart-sauce-labs-bolt-t-shirt","remove-sauce-labs-bolt-t-shirt"),
    Sauce_Labs_Fleece_Jacket("add-to-cart-sauce-labs-fleece-jacket","remove-sauce-labs-fleece-jacket"),
    Sauce_Labs_Onesie("add-to-cart-sauce-labs-onesie","remove-sauce-labs-onesie");


    private final String id;
    private final String removeId;

    Items(String id,String removeId){
        this.id = id;
        this.removeId = removeId;
    }

    public String getRemoveId() {
        return removeId;
    }

    public String getId() {
        return id;
    }
}
