/*
 * QuoteServiceTest.java
 *
 * Created on 2019-10-16, 14:04
 *
 * Copyright 2019 Marc Nuri San Felix
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
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
