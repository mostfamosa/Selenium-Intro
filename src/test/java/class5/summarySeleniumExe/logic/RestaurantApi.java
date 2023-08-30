package class5.summarySeleniumExe.logic;

import class5.summarySeleniumExe.Infra.HttpRequest;
import class5.summarySeleniumExe.Infra.ResponseWrapper;
import class5.summarySeleniumExe.logic.entities.DTOs.AllRestaurantsDTO;
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
    public static ResponseWrapper<RestaurantDTO> createNewRestaurant(String id, String name, String address, String score) {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "restaurant";
        // Create a map representing your body request data

        Map<String, String> bodyRequestData = new HashMap<>();
        bodyRequestData.put("id", id);
        bodyRequestData.put("name", name);
        bodyRequestData.put("score", score);
        bodyRequestData.put("address", address);

        String requestBody = buildBodyRequest(bodyRequestData);

        return HttpRequest.request(POST, url, requestBody, RestaurantDTO.class);
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
    public static ResponseWrapper<RestaurantDTO> editRestaurant(String id, String name, String address, String score) {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "restaurant/" + id;

        // Create a map representing your data
        Map<String, String> bodyRequestData = new HashMap<>();
        if (name != null)
            bodyRequestData.put("name", name);
        if (score != null)
            bodyRequestData.put("score", score);
        if (address != null)
            bodyRequestData.put("address", address);

        String requestBody = buildBodyRequest(bodyRequestData);

        return HttpRequest.request(PATCH, url, requestBody, RestaurantDTO.class);
    }

    //Gets all restaurants in the system
    public static ResponseWrapper<AllRestaurantsDTO> getAllRestaurants() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        String url = BASE_URL + "restaurants";
        return HttpRequest.request(GET, url, AllRestaurantsDTO.class);
    }
}
