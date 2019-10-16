/*
 * QuoteResource.java
 *
 * Created on 2019-10-16, 13:50
 */
package com.marcnuri.demo.fmpquarkus.quote;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Marc Nuri San Felix <marc@marcnuri.com> on 2019-10-16.
 */
@Path("/quotes")
public class QuoteResource {

  private static final String HEADER_QUOTE_AUTHOR = "Quote-Author";

  private QuoteService quoteService;

  @GET
  @Path("/random")
  public Response getRandomQuote() {
    final Quote randomQuote = quoteService.getRandomQuote();
    return Response
        .ok(randomQuote.getContent(), MediaType.TEXT_PLAIN_TYPE)
        .header(HEADER_QUOTE_AUTHOR, randomQuote.getAuthor())
        .build();
  }

  @Inject
  public void setQuoteService(QuoteService quoteService) {
    this.quoteService = quoteService;
  }
}
