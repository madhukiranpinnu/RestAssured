package com.Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test
    public void Test2(){
        Response response=given().queryParam("id",400)
                .log().all()
                .delete(" http://localhost:3000/employees/");
        response.prettyPrint();
    }
}
