package com.mystudent.studentinfo;

import com.mystudent.StudentPojo;
import com.mystudent.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    @Test
    public void updateStudentWithPut(){

        List<String> course=new ArrayList<>();
        course.add("Bmw");
        course.add("Toyota");

        StudentPojo studentPojo=new StudentPojo();

       studentPojo.setFirstName("Mike");
       studentPojo.setLastName("Hussy");
       studentPojo.setEmail("mike123@gmail.com");
       studentPojo.setProgramme("Driving");
       studentPojo.setCourses(course);

        Response response= given()
                .header("Content-Type", "application/json")
                .pathParam("id",101)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
