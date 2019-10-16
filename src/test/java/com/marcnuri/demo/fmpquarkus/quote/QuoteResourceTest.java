/*
 * QuoteResourceTest.java
 *
 * Created on 2019-10-16, 14:19
 */
package com.marcnuri.demo.fmpquarkus.quote;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyOrNullString;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * Created by Marc Nuri San Felix <marc@marcnuri.com> on 2019-10-16.
 */
@QuarkusTest
class QuoteResourceTest {

  @Test
  void getRandomQuote_shouldReturnOk() {
    given()
        .when()
          .get("/quotes/random")
        .then()
          .statusCode(200)
          .header("Quote-Author", not(isEmptyOrNullString()))
          .body(not(isEmptyOrNullString()));
  }
}
