package com.mystudent.studentinfo;

import com.mystudent.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentInfo(){
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo(){
        Response response= given()
                .pathParam("id",11)

                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithPara(){
        HashMap<String,Object>programme=new HashMap<>();
        programme.put("programme","Computer Science");

       programme.put("limit",2);

        Response response=given()
                .queryParams(programme)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudent(){

        Response response=given()
                .queryParam("programme","Disaster Management")
                .queryParam("limit",1)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
