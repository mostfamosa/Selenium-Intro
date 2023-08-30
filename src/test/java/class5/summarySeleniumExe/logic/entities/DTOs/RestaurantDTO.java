package class5.summarySeleniumExe.logic.entities.DTOs;

import lombok.Data;

@Data
public class RestaurantDTO {
    private String id;
    private String name;
    private double score;
    private String address;
    private boolean success;
    private String error;
    private int status;
}
