package it.jdk.demomicroservicesdeparment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoMicroservicesDeparmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroservicesDeparmentApplication.class, args);
	}



}
