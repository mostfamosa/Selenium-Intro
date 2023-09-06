package class5.summarySeleniumExe.test;

import class5.summarySeleniumExe.Infra.ResponseWrapper;
import class5.summarySeleniumExe.Infra.WebDriverWrapper;
import class5.summarySeleniumExe.logic.api.RestaurantApi;
import class5.summarySeleniumExe.logic.entities.DTOs.RestaurantDTO;
import class5.summarySeleniumExe.logic.pages.RestaurantListPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class RestaurantTest {

    private static final Logger logger = LogManager.getLogger(RestaurantTest.class);
    private ResponseWrapper<RestaurantDTO> response;
    private static WebDriverWrapper driverWrapper;
    private RestaurantListPage restaurantListPage;

    // default restaurant data to create
    private int restId;
    private String restName;
    private String restAddress;
    private double restScore;

    @BeforeAll
    public static void init() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        driverWrapper = new WebDriverWrapper();
    }

    @BeforeEach
    public void setUp() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //default restaurant data
        restId = 12222;
        restName = "Moose";
        restAddress = "HOME";
        restScore = 10.5;

        //reset the server
        response = RestaurantApi.resetRestaurants();
        logger.info(response.getData());

        //assume the reset of the server is success
        assumeTrue(response.getData().isSuccess(), "Error - can't reset the data");
        driverWrapper.getDriver().get("https://testomate-test.web.app/home");
        restaurantListPage = new RestaurantListPage(driverWrapper.getDriver());

    }

    @AfterAll
    public static void tearDown() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        driverWrapper.closeDriver();
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
    public void create_Restaurant_Via_Api() {
        //ACT
        restId = 199;
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        //ASSERT
        assertAll(
                //status validation
                () -> assertEquals(201, response.getStatus(), "Expected status code is 201"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(response.getData().isSuccess(), "Failed to create new restaurant!")
        );
    }

    @Test
    public void delete_Restaurant_Validation() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = 199;
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assumeTrue(response.getData().isSuccess(), "Failed to create new restaurant!");

        driverWrapper.refreshPage();

        //ACT
        restaurantListPage.deleteRestaurant(restId);
        String alertMsg = restaurantListPage.getAlertPopUp().getAlertMsg();
        restaurantListPage.getAlertPopUp().clickOnConfirmAlertBtn();
        boolean isFound = restaurantListPage.findRestaurantInPage(restId, restName, restAddress, restScore);

        //ASSERT
        assertAll(
                () -> assertEquals("Deleted!", alertMsg),
                () -> assertFalse(isFound, "Failed to delete the restaurant!")
        );
    }

    @Test
    public void update_Restaurant_Info_Validation() {
        logger.info("Current method name: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //ARRANGE
        restId = 11211;
        restScore = 5.5;
        response = RestaurantApi.createNewRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());

        assumeTrue(response.getData().isSuccess(), "Failed to create new restaurant!");

        driverWrapper.refreshPage();

        //ACT
        restName = "Assaf";
        restAddress = "GoTech Company";
        response = RestaurantApi.editRestaurant(restId, restName, restAddress, restScore);
        logger.info(response.getData());
        driverWrapper.refreshPage();
        boolean isFound = restaurantListPage.findRestaurantInPage(restId, restName, restAddress, restScore);

        //ASSERT
        assertAll(
                //status validation
                () -> assertEquals(200, response.getStatus(), "Expected status code is 200"),

                //not null validation
                () -> assertThat(response.getData().isSuccess(), notNullValue()),

                //data validation
                () -> assertTrue(isFound, "Failed to found the restaurant!"),
                () -> assertTrue(response.getData().isSuccess(), "Failed to update restaurant info!")
        );
    }
}