package class5.summarySeleniumExe.logic.entities.DTOs;

import lombok.Data;

@Data
public class RestaurantDTO {
    private boolean success;
    private String error;
    private String id;
    private String name;
    private double score;
    private String address;
}
