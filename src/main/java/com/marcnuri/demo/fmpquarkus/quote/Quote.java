/*
 * Quote.java
 *
 * Created on 2019-10-15, 7:21
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
