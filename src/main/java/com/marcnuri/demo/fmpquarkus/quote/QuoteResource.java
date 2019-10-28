/*
 * QuoteResource.java
 *
 * Created on 2019-10-16, 13:50
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
