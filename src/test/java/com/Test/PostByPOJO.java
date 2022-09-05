package com.Test;

import POJOClass.Food;
import POJOClass.JSONCl;
import POJOClass.Marks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import POJOClass.JSONCl;

import static io.restassured.RestAssured.given;

public class PostByPOJO {
    @Test
    public void T1(){
        Marks marks=new Marks(89,56);
        Marks marks1=new Marks(67,86);
        List<Marks> marks5= Arrays.asList(marks1,marks);
        List<String> dinner=Arrays.asList("poori","Chapathi");
        Food food=new Food("chapathi","rice",dinner);
        List<String> jobs= Arrays.asList("tester","shopkepeer");
        JSONCl jsonci=new JSONCl(953,"",null,"madhu@gmail.com",jobs,food,marks5);
        Response response = given().header("Content-Type", "application/json")
                .body(jsonci).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
