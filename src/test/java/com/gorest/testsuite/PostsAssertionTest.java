package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest {
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

    //1. Verify the if the total record is 25
    @Test
    public void test001() {
        response.body("total.size", equalTo(25));
    }

    //2. Verify the if the title of id = 57252 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test002() {
        response.body("find{it.id=57252}.title", equalTo("Aggero coerceo acceptus vereor molestias."));
    }

    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003() {
        response.body("[2].user_id", equalTo(4104753));
    }


    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004() {
        response.body("id", hasItems(57253, 57252, 57196));
    }
//5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
        //spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
        //Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
        //Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
        //antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
        // cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
        //adflicto. Assentator umquam pel."”
        @Test
        public void test005 () {
            response.body("find{it.user_id =4040709}.body", equalTo("Quas cito veritatis. Cunctatio quidem cras. Doloribus ut vitae. Toties causa advenio. Viscus depono tricesimus. Tui claustrum attollo. Corrupti curis solum. Tero adflicto complectus. Accipio eum crepusculum. Auditor clamo thalassinus. Undique patior accusantium. Absque stillicidium benevolentia. Umbra substantia acerbitas. Et spectaculum tolero. Utor voluptatum coniecto. Virtus bestia vesper. Clam auctus amissio. Acies decens ullus."));

        }

    }