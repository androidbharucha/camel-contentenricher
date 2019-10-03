package org.tiaa.training.camel.contentenricher.controller;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

public void configure() {
  // Define routing rules here:
  from("file:src/data?noop=true").to("file:target/messages");

  // More rules can be included, in you like.
  // ...
}
}