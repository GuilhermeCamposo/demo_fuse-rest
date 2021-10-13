package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class APIServerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
        restConfiguration()
		    .component("servlet");
		
		rest("/api")
		.get()
			.to("direct:impl");
		
		from("direct:impl")
		.setBody(simple("The date is : ${header.date}"));


	}

}
