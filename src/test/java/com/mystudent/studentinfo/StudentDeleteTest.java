package com.mystudent.studentinfo;

import com.mystudent.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudent1(){
        Response response = given()
                .pathParam("id",25)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();

    }
}
