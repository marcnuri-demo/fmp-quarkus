/*
 * QuoteService.java
 *
 * Created on 2019-10-15, 7:10
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
