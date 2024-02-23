package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static support.World.token;

public class RestAssuredHelper {

    public static RequestSpecification request;
    public static Response response;

    public void setBaseURI(String url) {
        RestAssured.baseURI = url;
        request = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .urlEncodingEnabled(false)
                .log().all();
    }

    public void setContentType(String contentType) {
        request.header("Content-Type", contentType);
    }

    public String setAuthToken(String token) {
        request.header("Authorization", "Bearer " + token);
        return token;
    }

    public void setRequestBody(String requestBody) {
        request.body(requestBody);
    }

    public Response postRequest(String apiUrl) {
        response = request.post(apiUrl);
        return response;
    }

    public Response getRequest(String endpoint) {
        response = request.get(endpoint);
        return response;
    }

    public Response getRequestEndPointParam(String endpoint, String queryParameters) {
        response = request.get(endpoint + queryParameters);
        return response;
    }

    public Response makeDeleteApiRequest(String apiUrl) {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .delete(apiUrl);
        return response;
    }

    public void verifyStatusCode(int code) {
        Assert.assertEquals(response.getStatusCode(), code, "Response code is not " + code);
    }

    public String getValueFromResponse(Response responses, String path) {
        String value = responses.path(path);
        return value;
    }
}