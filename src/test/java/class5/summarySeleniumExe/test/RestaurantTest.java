package class5.summarySeleniumExe.test;

import class5.summarySeleniumExe.Infra.ResponseWrapper;
import class5.summarySeleniumExe.logic.api.RestaurantApi;
import class5.summarySeleniumExe.logic.entities.DTOs.RestaurantDTO;
import class5.summarySeleniumExe.logic.pages.RestaurantListPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static class5.summarySeleniumExe.Infra.WebDriverManager.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    private static final Logger logger = LogManager.getLogger(RestaurantTest.class);
    private ResponseWrapper<RestaurantDTO> response;
    private static WebDriver driver;
    private RestaurantListPage restaurantListPage;

    // default restaurant data to create
    private String restId = "12222";
    private String restName = "Moose";
    private String restAddress = "HOME";
    private String restScore = "10";

    @BeforeAll
    public static void init() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        driver = getDriver();
    }

    @BeforeEach
    public void setUp() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        response = RestaurantApi.resetRestaurants();
        logger.info(response.getData());

        assertAll(
                () -> assertTrue(response.getData().isSuccess(), "Error - can't reset the data")
        );
        restaurantListPage = new RestaurantListPage(driver);

    }

    @AfterAll
    public static void tearDown() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        closeDriver();
    }

    @Test
    public void create_New_Restaurant_Validation() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ACT
        restaurantListPage.createNewRestaurant(restId, restName, restAddress, restScore);
        String alertMsg = restaurantListPage.getAlertPopUp().getAlertMsg();
        restaurantListPage.getAlertPopUp().clickOnConfirmAlertBtn();

        //ASSERT
        boolean isFound = restaurantListPage.findRestaurantInPage(restId, restName, restAddress, restScore);
        assertAll(
                () -> assertEquals("Created!", alertMsg),
                () -> assertTrue(isFound, "failed to found the restaurant!")
        );
    }

    @Test
    public void delete_Restaurant_Validation() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = "191";
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assertAll(
                //status validation
                () -> assertEquals(201, response.getStatus(), "Expected status code is 201"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to create new restaurant!")
        );

        refreshPage();

        //ACT
        boolean isDeleted = restaurantListPage.deleteRestaurant(restId);
        String alertMsg = restaurantListPage.getAlertPopUp().getAlertMsg();
        restaurantListPage.getAlertPopUp().clickOnConfirmAlertBtn();
        //ASSERT
        assertAll(
                () -> assertEquals("Deleted!", alertMsg),
                () -> assertTrue(isDeleted, "Failed to delete the restaurant!")
        );
    }

    @Test
    public void delete_Restaurant_Invalid_Id_Failed() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = "191";
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assertAll(
                //status validation
                () -> assertEquals(201, response.getStatus(), "Expected status code is 201"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to create new restaurant!")
        );

        refreshPage();

        //ASSERT
        assertAll(
                () -> assertThrows(TimeoutException.class, () -> {
                    //ACT
                    restaurantListPage.deleteRestaurant(restId + 99999);
                })
        );
    }

    @Test
    public void update_Restaurant_Info_Validation() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = "11211";
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assertAll(
                //status validation
                () -> assertEquals(201, response.getStatus(), "Expected status code is 201"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to create new restaurant!")
        );

        refreshPage();

        //ACT
        restName = "Assaf";
        restAddress = "GoTech Company";
        response = RestaurantApi.editRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        //ASSERT
        assertAll(
                //status validation
                () -> assertEquals(200, response.getStatus(), "Expected status code is 200"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to update restaurant info!")
        );

        refreshPage();


        boolean isFound = restaurantListPage.findRestaurantInPage(restId, restName, restAddress, restScore);
        assertAll(
                () -> assertTrue(isFound, "Failed to found the restaurant!")
        );
    }

    @Test
    public void update_Restaurant_Invalid_Id_Info_Failed() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = "11211";
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assertAll(
                //status validation
                () -> assertEquals(201, response.getStatus(), "Expected status code is 201"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to create new restaurant!")
        );

        refreshPage();

        restName = "Assaf";
        restAddress = "GoTech Company";
        restId += 9999999;

        response = RestaurantApi.editRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());


        assertAll(
                //status validation
                () -> assertEquals(404, response.getStatus(), "Expected status code is 404"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),
                () -> assertThat(response.getData().getError(), notNullValue()),

                //data validation
                () -> assertFalse(response.getData().isSuccess(), "Not Failed to update restaurant info!"),
                () -> assertThat(response.getData().getError(), equalTo("restaurant with given id not found"))
        );

        refreshPage();

        //ASSERT
        assertAll(
                () -> assertThrows(TimeoutException.class, () -> {
                    //ACT
                    restaurantListPage.findRestaurantInPage(restId, restName, restAddress, restScore);
                })
        );
    }
}