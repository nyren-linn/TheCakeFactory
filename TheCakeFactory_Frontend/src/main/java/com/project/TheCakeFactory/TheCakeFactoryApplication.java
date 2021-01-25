package com.project.TheCakeFactory;

import com.project.TheCakeFactory.player.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TheCakeFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCakeFactoryApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcome(@RequestParam(value = "name", defaultValue = "sugar") String name) {
		return String.format("Welcome %s!", name);
	}


}
