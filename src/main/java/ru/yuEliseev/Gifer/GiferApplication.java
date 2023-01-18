package ru.yuEliseev.Gifer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GiferApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiferApplication.class, args);
	}

}
