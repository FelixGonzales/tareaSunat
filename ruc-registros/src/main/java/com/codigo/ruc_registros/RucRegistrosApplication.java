package com.codigo.ruc_registros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RucRegistrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RucRegistrosApplication.class, args);
	}

}
