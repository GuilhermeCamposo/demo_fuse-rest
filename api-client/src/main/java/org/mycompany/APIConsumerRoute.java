package org.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class APIConsumerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("timer:my-timer?repeatCount=10")
		.setHeader(Exchange.HTTP_QUERY, simple("date=${date:now:yyyyMMdd}"))
		.to("http4://localhost:8080/camel/api")
		.log("This is the HTTP calll response ->>> ${body}");

	}

}
