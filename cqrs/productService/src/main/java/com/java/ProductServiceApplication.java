package com.java;

import com.java.command.api.events.ProductEventsHandler;
import com.java.command.api.exception.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.java.command.api.data")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Autowired
	public void  configure(EventProcessingConfigurer configurer){
		configurer.registerListenerInvocationErrorHandler(
				"product",configuration -> (ListenerInvocationErrorHandler) new ProductEventsHandler()
		);
	}

}
