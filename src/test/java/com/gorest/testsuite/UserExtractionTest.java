package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);
    }

    // 1. Extract the All Ids
    @Test
    public void test001(){
        List<Integer> allIds =response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the All Ids : " +allIds);
        System.out.println("------------------End of Test---------------------------");
    }


//2. Extract the all Names
@Test
public void test002(){
        List<String> allNames =response.extract().path("name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the all Names : " +allNames);
    System.out.println("------------------End of Test---------------------------");
}

//3. Extract the name of 5th object
@Test
public void test003(){
        String nameOfObject =response.extract().path("[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the name of 5th object : " +nameOfObject);
    System.out.println("------------------End of Test---------------------------");
}

//4. Extract the names of all object whose status = inactive
@Test
public void test004(){
    List<String> allNames =response.extract().path("findAll{it.status =='inactive'}.name");

    System.out.println("------------------StartingTest---------------------------");
   System.out.println("The value of limit is : " +allNames);
    System.out.println("------------------End of Test---------------------------");
}



//5. Extract the gender of all the object whose status = active
@Test
public void test005(){
    List<String> allGender =response.extract().path("findAll{it.status =='active'}.gender");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the gender of all the object whose status = active: " + allGender);
    System.out.println("------------------End of Test---------------------------");
}




//6. Print the names of the object whose gender = female
@Test
public void test006(){
        List<String> allNames =response.extract().path("findAll{it.gender =='female'}.name");


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Print the names of the object whose gender = female " + allNames);
    System.out.println("------------------End of Test---------------------------");
}



//7. Get all the emails of the object where status = inactive
@Test
public void test007(){
        List<String> allEmailOfObject =response.extract().path("findAll{it.status =='inactive'}.email");


    System.out.println("------------------StartingTest---------------------------");
   System.out.println("The value of limit is : " + allEmailOfObject);
    System.out.println("------------------End of Test---------------------------");
}


//8. Get the ids of the object where gender = male
@Test
public void test008(){
List<Integer> getIds =response.extract().path("findAll{it.gender =='male'}.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Get the ids of the object where gender = male : " + getIds);
    System.out.println("------------------End of Test---------------------------");
}


//9. Get all the status

    @Test
    public void test009(){
        List<String> allStatus =response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
       System.out.println(" Get all the status : " +allStatus);
        System.out.println("------------------End of Test---------------------------");
    }

//10. Get email of the object where name = Bhasvan Kapoor IV
@Test
public void test010(){
    String email =  response.extract().path("find{it.name == 'Bhasvan Kapoor'}.email");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Email of the object where name = Bhasvan Kapoor: " + email);
    System.out.println("------------------End of Test---------------------------");
}
//11. Get gender of id = 4040706



    @Test
    public void test0011() {
        String gender =  response.extract().path("find{it.id == '4040715'}.gender");

        //  String gender = response.extract().path("find{it.id = '4040715'}.gender");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("gender of id = 4040715: " + gender);
        System.out.println("------------------End of Test---------------------------");
    }

}