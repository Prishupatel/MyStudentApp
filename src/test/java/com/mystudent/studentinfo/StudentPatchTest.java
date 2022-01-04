package com.mystudent.studentinfo;

import com.mystudent.StudentPojo;
import com.mystudent.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudent(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setEmail("updateemaile12@gmail.com");               //we are update email id by using id

        Response response= RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("id",101)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
