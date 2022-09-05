package com.Test;

import POJOClass.JSONCl;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Requst1 {
    @Test
    public void Test1(){
     Response response=given().get(" http://localhost:3000/employees");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.SECONDS));
        System.out.println(response.getContentType());
        response.prettyPrint();
        Headers headers=response.headers();
        for(Header header:headers){
            System.out.println(header.getName());
            System.out.print(header.getValue());
        }
        System.out.println("-----------------------------------------");
        ResponseBody responseBody=response.getBody();
        String responseAsString=responseBody.asString();
        Assert.assertTrue(responseAsString.contains("Garrett"),"no string present specified");
    }
    @Test
    public void Test2() throws IOException {
        Response response=given().queryParam("id",1299)
                .log().all()
                .get(" http://localhost:3000/employees/");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
        Assert.assertTrue(response.jsonPath().getString("email").contains("madhu918@gmail.com"));
        System.out.println(response.jsonPath().getString("food.breakfast"));
        Assert.assertTrue(response.jsonPath().getString("food.breakfast").contains("idly"));
        response.then()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(new File("C:\\Users\\madhu\\RestAssured\\src\\test\\java\\resources\\schema.json")));
        //To Store response:
        Files.write(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\response.json"),response.asByteArray());
    }
}
