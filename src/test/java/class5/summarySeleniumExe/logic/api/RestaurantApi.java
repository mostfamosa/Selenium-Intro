package class5.summarySeleniumExe.logic.api;

import class5.summarySeleniumExe.Infra.HttpRequest;
import class5.summarySeleniumExe.Infra.ResponseWrapper;
import class5.summarySeleniumExe.logic.entities.DTOs.AllRestaurantsDTO;
import class5.summarySeleniumExe.logic.entities.DTOs.CreateRestaurantRequest;
import class5.summarySeleniumExe.logic.entities.DTOs.RestaurantDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static class5.summarySeleniumExe.logic.entities.enums.HttpMethods.*;


import java.util.HashMap;
import java.util.Map;


public class RestaurantApi {
    private static final Logger logger = LogManager.getLogger(RestaurantApi.class);

    private static final String BASE_URL = "https://us-central1-testomate-test.cloudfunctions.net/api/";


    //create new restaurant
    public static ResponseWrapper<RestaurantDTO> createNewRestaurant(int id, String name, String address, double score) {
        return HttpRequest.request(POST, BASE_URL + "restaurant", new CreateRestaurantRequest(id, name, score, address), RestaurantDTO.class);
    }

    //Build body request
    private static String buildBodyRequest(Map<String, String> bodyRequestData) {
        // Convert the map to a JSON string
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(bodyRequestData);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to build body request!");
            logger.error("Failed to build body request!\n");
            e.printStackTrace();
        }

        return null;
    }

    //Deletes a restaurant by id
    public static ResponseWrapper<RestaurantDTO> deleteRestaurant(String id) {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "restaurant/" + id;
        return HttpRequest.request(DELETE, url, RestaurantDTO.class);
    }

    //Resets restaurant data to default values
    public static ResponseWrapper<RestaurantDTO> resetRestaurants() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "reset";
        return HttpRequest.request(POST, url, RestaurantDTO.class);
    }

    //Updates a property of a restaurant
    public static ResponseWrapper<RestaurantDTO> editRestaurant(int id, String name, String address, double score) {
        return HttpRequest.request(PATCH, BASE_URL + "restaurant/" + id, new CreateRestaurantRequest(id, name, score, address), RestaurantDTO.class);
    }

    //Gets all restaurants in the system
    public static ResponseWrapper<AllRestaurantsDTO> getAllRestaurants() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "restaurants";
        return HttpRequest.request(GET, url, AllRestaurantsDTO.class);
    }
}
