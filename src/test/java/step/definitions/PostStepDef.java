package step.definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import module.PayloadManager;
import org.hamcrest.Matchers;

public class PostStepDef {

    private final String BASE_URL = "https://restful-booker.herokuapp.com";
    private PayloadManager payloadManager;
    private Response response ;

    @Given("Get Payload from {string} and Make a call")
    public void get_payload_from_and_make_a_call(String basePath) throws JsonProcessingException {
        payloadManager = new PayloadManager();
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(basePath);
        requestSpecification.contentType(ContentType.JSON);
        response  = requestSpecification.body(payloadManager.createPayload()).post();
    }


    @Then("Verify response message {string}")
    public void verifyResponseMessage(String responseCode) {
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(Integer.parseInt(responseCode));
        validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()",Matchers.is(15));
    }
}
