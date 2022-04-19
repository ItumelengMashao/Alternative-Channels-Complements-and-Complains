import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PartTwo {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://demo.guru99.com/V4/sinkministatement.php";
        Response response = null;

        response = given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
               // .body()
                .when()
                .get();


        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println(" Reponse " + response.asString());
    }
}
