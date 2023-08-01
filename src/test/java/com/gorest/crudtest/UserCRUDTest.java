package com.gorest.crudtest;

import com.gorest.model.PostPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
   @Test

    public void verifyUserCreatedSuccessfully(){
       String email = TestUtils.getRandomValue() + "riplav@yahoo.com";

       PostPojo postPojo = new PostPojo();
       postPojo.setName("Rupal");
       postPojo.setEmail(email);
       postPojo.setGender("male");
       postPojo.setStatus("active");

//make request to server to create new user
       Response response =given()
               .header("Content-Type","application/json")
               .header("Authorization", "Bearer 61d699e5415f5cab22ec102d1a3090dd453fc223ecd50952a2c702b22da3d293 ")
               .when()
               .body(postPojo)
               .post("/users");
       response.prettyPrint();
       response.then().statusCode(201);

   }
//4138570

   @Test

   public void verifyUserUpdatedSuccessfully() {
      String email = TestUtils.getRandomValue() + "riplav@yahoo.com";

      PostPojo postPojo = new PostPojo();
      postPojo.setName("Ronak");
      postPojo.setEmail(email);
      postPojo.setGender("female");
      postPojo.setStatus("inactive");

//make request to server to create new user
      Response response = given()
              .header("Content-Type", "application/json")
              .header("Authorization", "Bearer 61d699e5415f5cab22ec102d1a3090dd453fc223ecd50952a2c702b22da3d293 ")
              .when()
              .body(postPojo)
              .put("/users/4138685");
      response.prettyPrint();
      response.then().statusCode(200);

   }


@Test
        public void deleteUser() {
   Response response = given()
           .header("Content-Type", "application/json")
           .header("Authorization", "Bearer 61d699e5415f5cab22ec102d1a3090dd453fc223ecd50952a2c702b22da3d293 ")
           .when()
           .delete("/users/4138685");
   response.prettyPrint();
   response.then().statusCode(204);


}





}
