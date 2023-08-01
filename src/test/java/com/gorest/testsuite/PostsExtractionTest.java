package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);
    }

 //   1. Extract the title
 @Test
 public void test001(){
     List<String> allTitle =response.extract().path("title");
     System.out.println("------------------StartingTest---------------------------");
     System.out.println("Extract the All Ids : " +allTitle);
     System.out.println("------------------End of Test---------------------------");
 }

//2. Extract the total number of record
@Test
public void test002(){
    List<String> allRecord =response.extract().path("id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("the total number of record: " +allRecord.size());
    System.out.println("------------------End of Test---------------------------");
}


//3. Extract the body of 15th record
@Test
public void test003(){
    String bodyOfRecord =response.extract().path("[14].body");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the body of 15th record: " +bodyOfRecord);
    System.out.println("------------------End of Test---------------------------");
}



//4. Extract the user_id of all the records
@Test
public void test004(){
     List<Integer>allUser_id =response.extract().path("user_id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Extract the user_id of all the records: " +allUser_id);
    System.out.println("------------------End of Test---------------------------");
}

//5. Extract the title of all the records
@Test
public void test005(){
    List<String>allTitle =response.extract().path("title");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  Extract the title of all the records: " +allTitle);
    System.out.println("------------------End of Test---------------------------");
}


//6. Extract the title of all records whose user_id = 4104812
@Test
public void test006(){
    List<String>titleOfUser_id =response.extract().path("findAll{it.user_id ==4104812}.title");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  Extract the title of all records whose user_id = 4104812: " +titleOfUser_id);
    System.out.println("------------------End of Test---------------------------");
}


//7. Extract the body of all records whose id = 57253
@Test
public void test007(){
    List<String>bodyOfId =response.extract().path("findAll{it.id ==57253}.body");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  Extract the body of all records whose id = 57253: " +bodyOfId);
    System.out.println("------------------End of Test---------------------------");
}

















}
