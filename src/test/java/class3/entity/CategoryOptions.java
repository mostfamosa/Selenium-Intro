package class3.entity;

public enum CategoryOptions {
    ALL_CATEGORIES("All Categories"),
    ART("Art"),
    BABY("Baby"),
    BOOKS_AND_MAGAZINES("Books & Magazines"),
    BUSINESS_AND_INDUSTRIAL("Business & Industrial"),
    CAMERAS_AND_PHOTO("Cameras & Photo"),
    CELL_PHONES_AND_ACCESSORIES("Cell Phones & Accessories"),
    CLOTHING_SHOES_AND_ACCESSORIES("Clothing, Shoes & Accessories"),
    COINS_AND_PAPER_MONEY("Coins & Paper Money"),
    COLLECTIBLES("Collectibles"),
    COMPUTERS_TABLETS_AND_NETWORKING("Computers/Tablets & Networking"),
    CONSUMER_ELECTRONICS("Consumer Electronics"),
    CRAFTS("Crafts"),
    DOLLS_AND_BEARS("Dolls & Bears"),
    ENTERTAINMENT_MEMORABILIA("Entertainment Memorabilia"),
    EVERYTHING_ELSE("Everything Else"),
    GIFT_CARDS_AND_COUPONS("Gift Cards & Coupons"),
    HEALTH_AND_BEAUTY("Health & Beauty"),
    HOME_AND_GARDEN("Home & Garden"),
    JEWELRY_WATCHES("Jewelry & Watches"),
    MOVIE_AND_TV("Movies & TV"),
    MUSIC("Music"),
    MUSICAL_INSTRUMENTS_AND_GEAR("Musical Instruments & Gear"),
    PET_SUPPLIED("Pet Supplies"),
    POTTERY_AND_GLASS("Pottery & Glass"),
    REAL_ESTATE("Real Estate"),
    SPECIALTY_SERVICE("Specialty Services"),
    SPORTING_GOODS("Sporting Goods"),
    SPORTS_MEN_CARDS_AND_FANSHOP("Sports Mem, Cards & Fan Shop"),
    STAMPS("Stamps"),
    TICKETS_AND_EXPERIENCES("Tickets & Experiences"),
    TOYS_AND_HOBBIES("Toys & Hobbies"),
    TRAVEL("Travel"),
    VIDEO_GAMES_AND_CONSOLES("Video Games & Consoles"),
    EBAY_MORTORS("eBay Motors");



    private String value;

    CategoryOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
