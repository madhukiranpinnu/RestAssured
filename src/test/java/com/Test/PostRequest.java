package com.Test;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.*;
public class PostRequest {
    @Test
    public void T1() {
        String requestBody = "{\n" +
                "      \"id\": 108,\n" +
                "      \"first_name\": \"madhukiran\",\n" +
                "      \"last_name\": \"pinnu\",\n" +
                "      \"email\": \"madhu@gmail.com\"\n" +
                "    }";
        Response response = given().header("Content-Type", "application/json")
                .body(requestBody).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
    @Test
    public void T2(){
        Response response = given().header("Content-Type", "application/json")
                .body(new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\test.json")).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
    @Test
    public void T3() throws IOException {
        byte[] bytes= Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\test.json"));
        String requestAsString=new String(bytes);
        String replace=requestAsString.replace("109",String.valueOf(new Faker().number().numberBetween(1000,2000)))
                .replace("fname",String.valueOf(new Faker().name().firstName()))
                .replace("lname",String.valueOf(new Faker().name().lastName()))
                .replace("emailId",String.valueOf(new Faker().name().lastName()+"@gmail.com"));
        Response response = given().header("Content-Type", "application/json")
                .body(replace).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
    @Test
    public void T4() throws IOException {
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",1235);
        map.put("first_name","madhukiran");
        map.put("last_name","pinnu");
        map.put("email","madhuki@gmail.com");
        Response response = given().header("Content-Type", "application/json")
                .body(map).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
    @Test
    public void T4Advanced() throws IOException {
        Map<String,Object> map1 =new LinkedHashMap<>();
        map1.put("id",1299);
        map1.put("first_name","madhukiran");
        map1.put("last_name","pinnu");
        map1.put("email","madhuki@gmail.com");
        map1.put("email","madhu918@gmail.com");
        List list1= Arrays.asList("tester","shopkeeper");
        map1.put("jobs",list1);
        Map<String,Object> map2 =new LinkedHashMap<>();
        map2.put("breakfast","idly");
        map2.put("lunch","rice");
        List list2= Arrays.asList("chapathi","poori");
        map2.put("dinner",list2);
        map1.put("food",map2);
        Response response = given().header("Content-Type", "application/json")
                .body(map1).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
    @Test
    public void T5() throws IOException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",127907);
        jsonObject.put("first_name","madhukiran");
        jsonObject.put("last_name","pinnu");
        jsonObject.put("email","madhuki@gmail.com");
        jsonObject.accumulate("email","madhu918@gmail.com");
        jsonObject.putOpt("klkl",null);
        //jsonObject.putOnce("id",34);
        JSONArray jsonArray=new JSONArray();
        jsonArray.put("tester");
        jsonArray.put("shopkeeper");
        jsonObject.put("jobs",jsonArray);
        JSONObject jsonObject1 =new JSONObject();
        jsonObject1.put("breakfast","idly");
        jsonObject1.put("lunch","rice");
        JSONArray jsonArray1=new JSONArray();
        jsonArray1.put("poori");
        jsonArray1.put("chapathi");
        jsonObject1.put("dinner",jsonArray1);
        jsonObject.put("food",jsonObject1);
        Response response = given().header("Content-Type", "application/json")
                .body(jsonObject.toString()).log().all()
                .post(" http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
