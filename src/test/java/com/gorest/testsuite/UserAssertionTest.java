package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest {
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
    //1. Verify the if the total record is 20
    @Test
    public void test001(){
        response.body("total.size",equalTo(20));
    }

    // 2. Verify the if the name of id = 5487 is equal to ”Tarun Rana"”
    @Test
    public void test002(){
        response.body("[2].name",equalTo("Tarun Rana"));
    }


    // 3. Check the single ‘Name’ in the Array list (Bandhul Gill)

    @Test
    public void test003(){
        response.body("[1].name",equalTo("Bandhul Gill"));
    }



//4. Check the multiple ‘Names’ in the ArrayList (Kama Asan","Fr. Deenabandhu Sinha","Saraswati Dhawan")
@Test
public void test004(){
    response.body("name",hasItems("Kama Asan","Fr. Deenabandhu Sinha","Saraswati Dhawan"));
}


//5. Verify the emai of userid = 4040686is equal “eekalabya_pillai@muller.exam”
@Test
public void test005(){

    response.body("find{it.id=4040686}.email",equalTo("eekalabya_pillai@muller.example"));
}


    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){

        response.body("[7].status",equalTo("active"));
    }


    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){

        response.body("[1].gender",equalTo("female"));
    }



}
