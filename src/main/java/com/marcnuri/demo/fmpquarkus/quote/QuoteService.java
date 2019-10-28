/*
 * QuoteService.java
 *
 * Created on 2019-10-15, 7:10
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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marc Nuri San Felix <marc@marcnuri.com> on 2019-10-15.
 */
@Singleton
public class QuoteService {

  private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

  private static final String QUOTES_RESOURCE= "/quotes/quotes.json";

  private final List<Quote> quotes;

  public QuoteService() {
    quotes = new ArrayList<>();
  }

  @PostConstruct
  protected final void initialize() {
    final ObjectMapper objectMapper = new ObjectMapper();
    try (final InputStream quotesStream = QuoteService.class.getResourceAsStream(QUOTES_RESOURCE)) {
      quotes.addAll(objectMapper.readValue(quotesStream,
          objectMapper.getTypeFactory().constructCollectionType(List.class, Quote.class)));
    } catch (IOException e) {
      log.error("Error loading quotes", e);
    }
  }


  Quote getRandomQuote() {
    return quotes.get(ThreadLocalRandom.current().nextInt(quotes.size()));
  }

}
