/*
 * Quote.java
 *
 * Created on 2019-10-15, 7:21
 */
package com.marcnuri.demo.fmpquarkus.quote;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Marc Nuri San Felix <marc@marcnuri.com> on 2019-10-15.
 */
@RegisterForReflection
public class Quote implements Serializable {

  private static final long serialVersionUID = 7220781254754206616L;

  private String content;
  private String author;

  String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quote quote1 = (Quote) o;
    return Objects.equals(content, quote1.content) &&
        Objects.equals(author, quote1.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, author);
  }
}
