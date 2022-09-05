package com.Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class UpdateRequest {
    @Test
    public void T1(){
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("first_name","madhuk");
        map.put("last_name","pinnukiran");
        map.put("email","madhuki@gmail.com");
        Response response = given()
                .pathParam("id",1235)
                .header("Content-Type", "application/json")
                .body(map).log().all()
                .put(" http://localhost:3000/employees/{id}");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
