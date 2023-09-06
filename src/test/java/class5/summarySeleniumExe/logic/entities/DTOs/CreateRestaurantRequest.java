package class5.summarySeleniumExe.logic.entities.DTOs;

import lombok.Data;

@Data
public class CreateRestaurantRequest {
    private int id;
    private String name;
    private double score;
    private String address;

    public CreateRestaurantRequest() {
    }

    public CreateRestaurantRequest(int id, String name, double score, String address) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.address = address;
    }
}
