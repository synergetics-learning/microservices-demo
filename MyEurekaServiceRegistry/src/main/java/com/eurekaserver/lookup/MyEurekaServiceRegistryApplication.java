package com.eurekaserver.lookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEurekaServiceRegistryApplication.class, args);
	}

}
