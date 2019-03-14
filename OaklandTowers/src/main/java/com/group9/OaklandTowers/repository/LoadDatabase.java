package com.group9.OaklandTowers.repository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group9.OaklandTowers.model.*;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(PostalInfoRepository pIRepository, UserRepository uRepository) {
		return args -> {
			PostalInfo postalInfo = new PostalInfo("myInfo", "USA", "MI", "Troy", (short) 48083, "1234 test dr.");
			log.info("Preloading " + pIRepository.save(postalInfo));
			log.info("Preloading " + uRepository.save(new User("admin", "password", "asdf@example.com", (byte) 1, 100, postalInfo.getPost_id() )));
		};
	}
}