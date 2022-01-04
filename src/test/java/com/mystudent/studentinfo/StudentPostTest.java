package com.mystudent.studentinfo;

import com.mystudent.StudentPojo;
import com.mystudent.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

    @Test
    public void createNewStudent(){
        List<String> courses= new ArrayList<>();
        courses.add("Postman");
        courses.add("Selenium");
        courses.add("JIRA");

        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("QA Tester");
        studentPojo.setLastName("Prime QA");
        studentPojo.setEmail("xyzw12@gmail.com");
        studentPojo.setProgramme("API tester");
        studentPojo.setCourses(courses);

        Response response = given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();



    }


}
