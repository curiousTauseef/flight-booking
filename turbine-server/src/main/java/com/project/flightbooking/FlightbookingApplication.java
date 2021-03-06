package com.project.flightbooking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTurbineAmqp
@EnableTurbineStream
@EnableEurekaClient
public class FlightbookingApplication {

	private static final Logger LOG = LoggerFactory.getLogger(FlightbookingApplication.class);
	@Value("${app.rabbitmq.host:localhost}")
	String rabbitMQHost;

	@Bean
	public ConnectionFactory connectionFactory() {
		LOG.info("Creating RabbitMQHost ConnectionFactory for host: {}", rabbitMQHost);
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitMQHost);
		return cachingConnectionFactory;
	}


	public static void main(String[] args) {
		SpringApplication.run(FlightbookingApplication.class, args);
	}
}
