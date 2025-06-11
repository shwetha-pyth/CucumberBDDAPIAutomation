package step.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;

public class GetBookingStepDef {

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "https://restful-booker.herokuapp.com";

    @Before
    public void before(Scenario scenariocval){
        this.scenario = scenariocval;
    }

    @Given("Get Call to {string}")
    public void getCallTo(String basePath) throws URISyntaxException {
        // This is Code will Run When you run the Feature file
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(basePath));

    }

    @Then("Response Code {string} is verified")
    public void responseCodeIsVerified(String responseCode) {
        response.then().log().all().statusCode(Integer.parseInt(responseCode));
        System.out.println(response.prettyPrint());
    }
}
