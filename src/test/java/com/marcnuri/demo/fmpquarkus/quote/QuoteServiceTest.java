/*
 * QuoteServiceTest.java
 *
 * Created on 2019-10-16, 14:04
 */
package com.marcnuri.demo.fmpquarkus.quote;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by Marc Nuri San Felix <marc@marcnuri.com> on 2019-10-16.
 */
class QuoteServiceTest {

  private QuoteService quoteService;

  @BeforeEach
  void setUp() {
    quoteService = new QuoteService();
    quoteService.initialize();
  }

  @Test
  void getRandomQuote_na_shouldReturnRandomQuote() {
    // When
    final Quote result = quoteService.getRandomQuote();
    // Then
    assertThat(result, notNullValue());
    assertThat(result.getAuthor(), not(isEmptyOrNullString()));
    assertThat(result.getContent(), not(isEmptyOrNullString()));
  }
}
