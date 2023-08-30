package class5.summarySeleniumExe.Infra;

import class5.summarySeleniumExe.logic.entities.enums.HttpMethods;
import class5.summarySeleniumExe.utils.ValidateJson;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpRequest {
    private static final Logger logger = LogManager.getLogger(HttpRequest.class);

    //request without param & header
    public static <T> ResponseWrapper<T> request(HttpMethods httpMethods, String url, String body, Class<T> clz) {
        return request(httpMethods, url, null, body, null, clz);
    }

    //request without param & header & body
    public static <T> ResponseWrapper<T> request(HttpMethods httpMethods, String url, Class<T> clz) {
        return request(httpMethods, url, null, null, null, clz);
    }

    // Overloaded method for request without header
    public static <T> ResponseWrapper<T> request(HttpMethods httpMethods, String url, Map<String, String> queryParams, Class<T> clz) {
        return request(httpMethods, url, queryParams, null, null, clz);
    }

    // Overloaded method for request without param
    public static <T> ResponseWrapper<T> requestWithoutParam(HttpMethods httpMethods, String url, Map<String, String> headers, Class<T> clz) {
        return request(httpMethods, url, null, null, headers, clz);
    }

    public static <T> ResponseWrapper<T> request(HttpMethods httpMethods, String url, Map<String, String> queryParams, String requestBody, Map<String, String> headers, Class<T> clz) {
        ResponseWrapper<T> responseWrapper = new ResponseWrapper<>();
        logger.info("Current method name: " +Thread.currentThread().getStackTrace()[1].getMethodName());

        // Set the param of the request if found!
        if (queryParams != null) {
            String queryString = queryParams.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"));
            url += "?" + queryString;
        }

        ClassicHttpRequest request;
        switch (httpMethods) {
            case POST -> {
                // Create an instance of HttpPost with the URL
                request = new HttpPost(url);

                // Set the request body for POST requests
                if (requestBody != null) {
                    StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                    request.setEntity(entity);
                } else {
                    // Set an empty request body
                    request.setEntity(new StringEntity("", ContentType.APPLICATION_JSON));
                }
            }
            case GET -> {
                // Create an instance of HttpGet with the URL
                request = new HttpGet(url);

            }
            case PATCH -> {
                request = new HttpPatch(url);
                // Set the request body for PATCH requests
                if (requestBody != null) {
                    StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                    request.setEntity(entity);
                }
            }
            case DELETE -> {
                request = new HttpDelete(url);
            }
            default -> {
                logger.error("Error of Bad Method:\n");
                throw new RuntimeException("Bad Method!");
            }
        }
        // Set the headers of the request
        if (headers != null) {
            for (String key : headers.keySet()) {
                request.setHeader(key, headers.get(key));
            }
        }
        logger.info("Request info : "+ request);
        // Create an instance of CloseableHttpClient
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Execute
            execute(httpClient, request, responseWrapper, clz);
        } catch (IOException e) {
            logger.error("Error of creating an instance of CloseableHttpClient:\n" + e);
            throw new RuntimeException("Error of creating an instance of CloseableHttpClient:\n" + e);
        }
        return responseWrapper;
    }

    public static <T> void execute(CloseableHttpClient httpClient, ClassicHttpRequest httpMethod, ResponseWrapper<T> responseWrapper, Class<T> clz) {
        logger.info("Current method name: " +Thread.currentThread().getStackTrace()[1].getMethodName());

        // Execute the request and get the response
        try (CloseableHttpResponse response = httpClient.execute(httpMethod)) {
            // Get the response status code
            responseWrapper.setStatus(response.getCode());

            // Get the response entity
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            // Validate Json
            responseWrapper.setData(ValidateJson.validate(clz, responseBody));
            logger.info("Response info : "+responseWrapper);

        } catch (IOException | ParseException e) {
            logger.error("Failed to execute request : " + httpMethod.getRequestUri() + "\n" + e);
            throw new RuntimeException(e);
        }
    }
}
