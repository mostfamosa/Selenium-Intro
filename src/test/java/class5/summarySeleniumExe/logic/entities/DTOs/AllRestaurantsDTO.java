package class5.summarySeleniumExe.logic.entities.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class AllRestaurantsDTO{
    private boolean success;
    private String error;
    private List<RestaurantDTO> data;
}
